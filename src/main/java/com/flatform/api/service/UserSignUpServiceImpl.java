package com.flatform.api.service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.*;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.flatform.api.security.TokenManagement;
import com.flatform.api.model.dao.UserSignUpDAO;
import com.flatform.api.model.dto.UserSignUpDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service("UserSignUpService")
@RequiredArgsConstructor
public class UserSignUpServiceImpl implements UserSignUpService
{
    @Autowired
    UserSignUpDAO userSignUpDAO;

    @Autowired
    TokenManagement tokenManagement;

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


    @Override
    public Map<String, String> createUser(UserSignUpDTO userSignUpDTO)
    {
        //AWS S3 버킷 이름, 주소
        String endpoint = "s3.ap-northeast-2.amazonaws.com";
        String bucketName = "media-resource-42flatform";

        //AWS Access Key & Secret Key
        String accesskey = "AKIAWHO5YRFIHP6CET3X";
        String secretkey = "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";

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
        String memberId = userSignUpDTO.getId();

        // json 으로부터 프로필 이미지 encoded string 추출
        String profileImgStrbase64 = userSignUpDTO.getProfile_img_root();
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
            userSignUpDTO.setProfile_img_root(profileImgRoot);

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
        userSignUpDTO.setRefreshtoken(newrefreshtkn);

        //DB에 회원정보 넣기
        userSignUpDAO.userSignUp(userSignUpDTO);

        // 발급한 access token, refresh token 을 Controller에게 리턴
        tokenTable.put("SIGNUP_STATUS", "SUCCESS");
        tokenTable.put("ACCESS_TOKEN", newaccesstkn);
        tokenTable.put("REFRESH_TOKEN", newrefreshtkn);

        return tokenTable;
    }
}
