package com.flatform.api.service;

import com.flatform.api.TokenMgmt.TokenManagement;
import com.flatform.api.model.dao.UserLoginDAO;
import com.flatform.api.model.dto.UserLoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service("UserLoginService")
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    TokenManagement tokenManagement;

    @Autowired
    UserLoginDAO userLoginDAO;

    @Override
    public Map verifyUser(UserLoginDTO userLoginDTO) {
        // login DTO 로부터 ID , PW 추출
        String userIdFromClient = userLoginDTO.getMemberId();
        String userPWFromClient = userLoginDTO.getMemberPW();

        // DB 로부터 ID, PW 추출
        String userIdFromDB = userLoginDAO.verifyUseridDB(userIdFromClient);
        String userPWFromDB = userLoginDAO.verifyUserpwDB(userIdFromClient);

        //DB의 id, pw값 비교해서 모두 참이면 리프레시 토큰과 엑세스 토큰 발급
        //일치하지 않으면 에러 반환
        if(((userIdFromClient.equals(userIdFromDB)) && (userPWFromClient.equals(userPWFromDB))))
        {//access tokwn , refresh token 발급
            System.out.println("OFOFOFORORORO");
            // 발급받은 access, refresh 토큰 변수에 저장
            String newAccesstoken = tokenManagement.generateAccessToken(userIdFromDB);
            String newRefreshtoken = tokenManagement.generateRefreshToken(userIdFromDB);


            // 리프레시 토큰 DB에 저장
            HashMap<String, Object> saveRefreshTokenObj = new HashMap<>();
            saveRefreshTokenObj.put("memberid", userIdFromDB);
            saveRefreshTokenObj.put("refreshToken", newRefreshtoken);

            System.out.println(saveRefreshTokenObj);

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
}
