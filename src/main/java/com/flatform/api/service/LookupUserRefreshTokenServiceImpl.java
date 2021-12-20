package com.flatform.api.service;

import com.flatform.api.TokenMgmt.TokenManagement;
import com.flatform.api.model.dao.GetRefreshTokenDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


@Service("LookupUserRefreshTokenService")
@RequiredArgsConstructor
public class LookupUserRefreshTokenServiceImpl implements LookupUserRefreshTokenService{

    @Autowired
    GetRefreshTokenDAO getRefreshTokenDAO;

    @Autowired
    TokenManagement tokenManagement;
    @Override
    public List getNewAccessToken(String refreshTokenValue, String userId) throws UnsupportedEncodingException {
        String refreshTokenFromClient = refreshTokenValue;
        String newAccessToken = "";
        // DB에서 리프레시 토큰 가져오기
        String refreshTokenFromDB = getRefreshTokenDAO.getRefTkn(userId);

        //리프레시 토큰 검증값이 참이면 리프레시 토큰 일치여부 확인 후 엑세스 토큰 발급
        //검증값 false면 에러메세지 반환

        if(tokenManagement.refreshTokenVerify(refreshTokenFromClient, userId))
        {
            System.out.println(refreshTokenFromDB);
            System.out.println(refreshTokenFromClient);
            if(refreshTokenFromClient.equals(refreshTokenFromDB))
            {
                System.out.println(1);
                newAccessToken = tokenManagement.generateAccessToken(userId);
            }
            else
            {
                newAccessToken = "refresh Token unmatch";
            }
        }
        else
        {
            newAccessToken = "refresh Token expired";
        }

        ArrayList<String> result = new ArrayList<>();
        result.add(newAccessToken);
        return result;
    }
}
