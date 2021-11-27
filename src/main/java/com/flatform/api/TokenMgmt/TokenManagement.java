//전체적 정리 필요

package com.flatform.api.TokenMgmt;

import com.flatform.api.model.dao.getRefreshTokenDAO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;


import java.util.Date;
import java.util.HashMap;

import java.util.Map;


@Component
public class TokenManagement {

    getRefreshTokenDAO getRefreshTokendao;

    Long ACCESS_TOKEN_EXP_TIME = 100l; // 아직 임시 데이터
    Long REFRESH_TOKEN_EXP_TIME = 1000l;  // 아직 임시 데이터

    public String generateAcessToken(String memberId){

        String key = "A";
        Map<String, Object> headers = new HashMap<>();
        headers.put("typ", "JWT");
        headers.put("alg", "HS256");

        //payload
        Map<String, Object> payloads = new HashMap<>();

        Long expiredTime = 1000L ;//만료시간
        Date tokenTime = new Date();
        tokenTime.setTime(tokenTime.getTime() + expiredTime);
        //토큰에 들어갈 내용
        payloads.put("data", memberId);
        payloads.put("sub", "accesstoken");
        payloads.put("iat", new Date().getTime());
        payloads.put("exp", tokenTime); // 만료시간

        //토큰 생성
        String createdaccjwt = Jwts.builder()
                .setHeader(headers)
                .setClaims(payloads)
                .signWith(SignatureAlgorithm.HS256, key.getBytes())
                .compact();

        return createdaccjwt;
    }

    public String generateRefreshToken(String memberId)
    {
        String key = "B";
        //header
        Map<String, Object> headers = new HashMap<>();
        headers.put("typ", "JWT");
        headers.put("alg", "HS256");

        //payload
        Map<String, Object> payloads = new HashMap<>();

        Long expiredTime = 1000L ;//만료시간
        Date tokenTime = new Date();
        tokenTime.setTime(tokenTime.getTime() + expiredTime);
        //토큰에 들어갈 내용
        payloads.put("data", memberId);
        payloads.put("sub", "refreshToken");
        //payloads.put("iat", new Date().getTime());
        payloads.put("exp", tokenTime); // 만료시간

        //토큰 생성
        String createdrefjwt = Jwts.builder()
                .setHeader(headers)
                .setClaims(payloads)
                .signWith(SignatureAlgorithm.HS256, key.getBytes())
                .compact();

        return createdrefjwt;
    }

    //토큰 까기
    public boolean accTokenDecode(String token)
    {
        boolean result = false;
        String key = "A";
        try {
            //토큰 해독
            Claims claims = Jwts.parser()
                    .setSigningKey(key.getBytes("UTF-8"))
                    .parseClaimsJws(token) // 토큰 검증
                    .getBody();

            result = true;
        } catch(ExpiredJwtException e) {// token 만료
            result= false;
        } catch (Exception e) { // 그외 에러
            result = false;
        }
        return result;

    }

    public String refTokenDecode(String token)
    {
        String key = "B";
        String result = "";
        try {
            //토큰 해독
            Claims claims = Jwts.parser()
                    .setSigningKey(key.getBytes("UTF-8"))
                    .parseClaimsJws(token)
                    .getBody();
            result = claims.get("data", String.class);
        } catch(ExpiredJwtException e) {// token 만료
            result = "Expired";
        } catch (Exception e) { // 그외 에러
            result="error";
        }
        return result;

    }
    //토큰을 검증하고 토큰 종류를 반환
    public String TokenVerity(String accTknValue, String refTknValue)
    {
        //access 토큰만 왔을 때
        if(accTknValue.length()>0 && refTknValue.length() == 0) {
            boolean decodedAccTkn = accTokenDecode(accTknValue);
            if (decodedAccTkn) {
                return "accTokenOK";
            } else {
                return "accTokenFail";
            }
        }
        else if(accTknValue.length()>0 && refTknValue.length() > 0)
        {
            String decodedRefTkn = refTokenDecode(refTknValue);
            String memberID = decodedRefTkn;
            //db에서 회원 아이디와  리프레시 토큰 값 얻어오기
            String dbTkn = getRefreshTokendao.getRefTkn(memberID);

            if(refTknValue == dbTkn)
            {
                return generateAcessToken(memberID);
            }
            else {
                return "refTokenFail";
            }
        }
        else
        {
            return "error";
        }
    }
}
