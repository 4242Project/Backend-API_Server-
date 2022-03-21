package com.flatform.api.service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.flatform.api.repository.dao.*;
import com.flatform.api.repository.dto.MemberStampNumDTO;
import com.flatform.api.repository.dto.UserInfoEntity;
import com.flatform.api.repository.dto.UserLoginDTO;
import com.flatform.api.security.TokenManagement;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.util.*;

@Service
@RequiredArgsConstructor
public class UserService
{

    @Autowired
    UserInfoRepository userInfoRepository;
    @Autowired
    TokenManagement tokenManagement;


    public List<Object> getNewAccessToken(String refreshTokenValue, String userId)
    {
        // DB 에서 리프레시 토큰 가져오기
        Optional<UserInfoEntity> refreshTokenEntityList = userInfoRepository.findById(userId);
        String refreshTokenFromDB = refreshTokenEntityList.get().getRefreshtoken();

        System.out.println(refreshTokenFromDB);
        //리프레시 토큰 검증값이 참이면 리프레시 토큰 일치여부 확인 후 엑세스 토큰 발급
        //검증값 false 면 에러메세지 반환
        ArrayList<Object> result = new ArrayList<>();
        HashMap<String, Object> tokenData = new HashMap<>();

        if(tokenManagement.refreshTokenVerify(refreshTokenValue))
        {
            String newAccessToken;
            if(refreshTokenValue.equals(refreshTokenFromDB))
            {
                newAccessToken = tokenManagement.generateAccessToken(userId);
            }
            else
            {
                newAccessToken = "refresh Token Error";
            }
            tokenData.put("New_Access_Token", newAccessToken);
            result.add(tokenData);
        }
        else
        {
            String newAccessToken = "refresh Token expired";
            result.add(newAccessToken);
        }
        return result;
    }

    @Autowired
    MemberStampNumDAO memberStampNumDAO;

    public Optional<MemberStampNumDTO> getMemberStampNumber(String member_id)
    {
        return memberStampNumDAO.getMemberStampNum(member_id);
    }




    @Autowired
    UserLoginDAO userLoginDAO;

    public Map<String, Object> verifyUser(UserLoginDTO userLoginDTO)
    {
        // login DTO 로부터 ID , PW 추출
        String userIdFromClient = userLoginDTO.getId();
        String userPWFromClient = userLoginDTO.getPw();

        // DB 로부터 ID, PW 추출
        String userIdFromDB = userLoginDAO.verifyUseridDB(userIdFromClient);
        String userPWFromDB = userLoginDAO.verifyUserpwDB(userIdFromClient);

        //DB의 id, pw값 비교해서 모두 참이면 리프레시 토큰과 엑세스 토큰 발급
        //일치하지 않으면 에러 반환
        if(((userIdFromClient.equals(userIdFromDB)) && (userPWFromClient.equals(userPWFromDB))))
        {
            //access tokwn , refresh token 발급
            // 발급받은 access, refresh 토큰 변수에 저장
            String newAccesstoken = tokenManagement.generateAccessToken(userIdFromDB);
            String newRefreshtoken = tokenManagement.generateRefreshToken(userIdFromDB);

            // 리프레시 토큰 DB에 저장
            HashMap<String, Object> saveRefreshTokenObj = new HashMap<>();
            saveRefreshTokenObj.put("memberid", userIdFromDB);
            saveRefreshTokenObj.put("refreshToken", newRefreshtoken);

            //System.out.println(saveRefreshTokenObj);

            userLoginDAO.saveRefreshToken(saveRefreshTokenObj);

            // access, refresh token 반환
            Map<String, Object> tokenTable = new HashMap<>();
            tokenTable.put("LOGIN_STATUS", "SUCCESS");
            tokenTable.put("ACCESS_TOKEN", newAccesstoken);
            tokenTable.put("REFRESH_TOKEN", newRefreshtoken);

            return tokenTable;
        }

        // 에러 시 로그인 실패 반환
        Map<String, Object> errObj = new HashMap<>();
        errObj.put("LOGIN_STATUS", "FAIL");
        return errObj;
    }


    @Autowired
    UserSignUpChkDAO userSignUpChkDAO;

    public List<Object> checkId(String targetId){
        boolean idChk =  userSignUpChkDAO.searchId(targetId);
        ArrayList<Object> result = new ArrayList<>();

        HashMap<String, Object> data = new HashMap<>();

        data.put("check", idChk);
        result.add(data);

        return result;
    }



    @Autowired
    UserInfoRepository userSignUpRepository;

    // 캐시 만료 기간 설정을 위해 1년을의 시간정보를 생성
    public static Date getOneYearsFromNow()
    {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.YEAR, 1);
        return c.getTime();
    }


    //Base64 로 인코딩된 이미지로부터 원래 이미지 데이터로 변환한다.
    static String ext;
    public static File ImageFromBase64Str(String base64Str, String fileName)
    {
        String[] str = base64Str.split(",");
        switch (str[0])
        {
            case "data:image/jpeg;base64":
                ext = "jpeg";
                break;
            case "data:image/png;base64":
                ext = "png";
                break;
            default:
                ext = "jpg";
                break;
        }

        byte[] imgdata = DatatypeConverter.parseBase64Binary(str[1]);
        File file = new File(fileName +"."+ ext);
        try(OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file)))
        {
            outputStream.write(imgdata);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return file;
    }


    public Map<String, String> createUser(UserInfoEntity userSignUpEntity)
    {
        //AWS S3 버킷 이름, 주소
        String endpoint = "";
        String bucketName = "";

        //AWS Access Key & Secret Key
        String accesskey = "";
        String secretkey = "";

        //AWS S3 클라리언트 연결 설정
        AWSCredentials credentials = new BasicAWSCredentials(accesskey, secretkey);
        AmazonS3 s3client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.AP_NORTHEAST_2)
                .build();

        // 생성된 토큰 정볼르 저장할 빈 HashMap 생성
        Map<String, String> tokenTable = new HashMap<>();

        //회원가입 정보로부터 id 값 추출
        String memberId = userSignUpEntity.getId();

        // json 으로부터 프로필 이미지 encoded string 추출
        String profileImgStrbase64 = userSignUpEntity.getProfileImgRoot();
        try
        {
            //base64 string 을 file object 로 변환
            File profileImgFile = ImageFromBase64Str(profileImgStrbase64, memberId);

            //S3 에 저장될 파일명
            String fname = memberId +"." + ext;

            //업로드된 파일의 주소
            String profileImgRoot = "https://"+bucketName+"."+endpoint+"/member_profile_img/profileImg_"+fname;

            //S3 Bucket 에 이미지 넣기
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setCacheControl("51635000");
            metadata.setExpirationTime(getOneYearsFromNow());
            s3client.putObject(new PutObjectRequest("media-resource-42flatform", "member_profile_img/profileImg_"+fname, profileImgFile)
                    .withCannedAcl(CannedAccessControlList.PublicRead).withMetadata(metadata));

            //DTO 에 URL(S3에 업로드 된 이미지 파일) 넣기
            userSignUpEntity.setProfileImgRoot(profileImgRoot);

            // 성공 메세지
            tokenTable.put("PROFIFLE_IMG_REGISTER", "SUCCESS");
        }
        catch (Exception e)
        {
            tokenTable.put("PROFIFLE_IMG_REGISTER", "FAILED"+e);
        }


        //ID값 정보로부터 ACCESS Token, Refresh Token 발급
        String newaccesstkn = tokenManagement.generateAccessToken(memberId);
        String newrefreshtkn = tokenManagement.generateRefreshToken(memberId);

        //userSignUp  DTO 에 발급한 리프레시 트콘 넣기
        userSignUpEntity.setRefreshtoken(newrefreshtkn);

        //DB에 회원정보 넣기
        userSignUpRepository.save(userSignUpEntity);

        // 발급한 access token, refresh token 을 Controller에게 리턴
        tokenTable.put("SIGNUP_STATUS", "SUCCESS");
        tokenTable.put("ACCESS_TOKEN", newaccesstkn);
        tokenTable.put("REFRESH_TOKEN", newrefreshtkn);

        return tokenTable;
    }
}
