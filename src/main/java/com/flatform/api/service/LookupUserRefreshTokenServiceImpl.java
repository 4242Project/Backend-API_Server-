package com.flatform.api.service;

import com.flatform.api.TokenMgmt.TokenManagement;
import com.flatform.api.model.dao.GetRefreshTokenDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service("LookupUserRefreshTokenService")
@RequiredArgsConstructor
public class LookupUserRefreshTokenServiceImpl implements LookupUserRefreshTokenService{

    @Autowired
    GetRefreshTokenDAO getRefreshTokenDAO;

    @Autowired
    TokenManagement tokenManagement;
    @Override
    public List<Object> getNewAccessToken(String refreshTokenValue, String userId) {
        // DB에서 리프레시 토큰 가져오기
        String refreshTokenFromDB = getRefreshTokenDAO.getRefTkn(userId);

        //리프레시 토큰 검증값이 참이면 리프레시 토큰 일치여부 확인 후 엑세스 토큰 발급
        //검증값 false면 에러메세지 반환
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
}
