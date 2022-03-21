
package com.flatform.api.security;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component // 클래스를 Bean으로 등록
public class TokenManagement {
    //비밀키 생성
    @Value("${jwt.password}")
    private String secretkey;

    final String issue = "42API";
    // access token 만료시간 간격 4시간
    Long ACCESS_TOKEN_EXP_TIME = 1000 * 60L * 60L * 4L;
    // refresh token 만료시간 간격 2주
    Long REFRESH_TOKEN_EXP_TIME = (1000 * 60L * 60L * 24L)*14L;

    @PostConstruct
    protected void init(){
        secretkey = Base64.getEncoder().encodeToString(secretkey.getBytes());
    }


    // Acess Token 생성
    public String generateAccessToken(String userId)
    {
        //header 설정
        Map<String, Object> headers = new HashMap<>();
        headers.put("alg", "HS256");
        headers.put("typ", "JWT");

        //payload 설정
        Map<String, Object> payload = new HashMap<>();
        Date exp = new Date();                                              // access token 의 유효기간 설정
        exp.setTime(exp.getTime() + ACCESS_TOKEN_EXP_TIME);

        payload.put("iss", issue);                                          // 발급자
        payload.put("sub", "accessToken");                                  // 토큰 제목
        payload.put("aud", userId);                                         // 토큰 대상자 : 사용자 아이디
        payload.put("exp", exp);                                            // 토큰 유효기간


        // 토큰 생성
        return Jwts.builder()
                .setHeader(headers)                                         // 헤더 넣기
                .setClaims(payload)                                         // payload 넣기
                .setSubject("accessToken")                                  // 용도
                .setExpiration(exp)                                         // 만료기한
                .signWith(SignatureAlgorithm.HS256, secretkey.getBytes())   // HS256, Secret key 서명 작성
                .compact();                                                 // 토큰 생성
    }




    // Refresh Token 생성
    public String generateRefreshToken(String userId)
    {
        //header 설정
        Map<String, Object> headers = new HashMap<>();
        headers.put("alg", "HS256");
        headers.put("typ", "JWT");


        //payload 설정
        Map<String, Object> payload = new HashMap<>();

        Date exp = new Date();                                              // refresh token 의 유효기간 설정
        exp.setTime(exp.getTime() + REFRESH_TOKEN_EXP_TIME);

        payload.put("iss", issue);                                          // 발급자
        payload.put("sub", "refreshToken");                                 // 토큰 제목
        payload.put("aud", userId);                                         // 토큰 대상자 : 사용자 아이디
        payload.put("exp", exp);                                            // 토큰 유효기간


        // 토큰 생성
        return Jwts.builder()
                .setHeader(headers)                                         // 헤더 넣기
                .setClaims(payload)                                         // payload 넣기
                .setSubject("refreshToken")                                 // 용도
                .setExpiration(exp)                                         // 만료기한
                .signWith(SignatureAlgorithm.HS256, secretkey.getBytes())   // HS256, Secret key 서명 작성
                .compact();                                                 // 토큰 생성
    }



    // access token 검증
    public boolean accessTokenVerify(String accessToken) {
        Map<String, Object> jwtClaimMap;
        try
        {
            // access token String 으로부터 claim 테이블을 추출하여 jwtClaimMap 에 저장
            jwtClaimMap = Jwts.parser()
                    .setSigningKey(secretkey.getBytes(StandardCharsets.UTF_8))
                    .parseClaimsJws(accessToken)
                    .getBody();

            //토큰으로부터 정보 추출
            String issuer = (String)jwtClaimMap.get("iss");                 // access token 발급자 추출
            String subject = (String)jwtClaimMap.get("sub");                // acess token 용도 추출

            // 토큰 검증 로직 시작
            return ((issuer.equals(issue)) && (subject.equals("accessToken")));
        }
        // refresh token 만료 및 그외 에러시
        catch(Exception e)
        {
            return false;
        }
    }



    // refresh token 검증
    public boolean refreshTokenVerify(String refreshToken)
    {
        Map<String, Object> jwtClaimMap;
        try
        {
            // access token String 으로부터 claim 테이블을 추출하여 jwtClaimMap 에 저장
            jwtClaimMap = Jwts.parser()
                    .setSigningKey(secretkey.getBytes(StandardCharsets.UTF_8))
                    .parseClaimsJws(refreshToken)
                    .getBody();


            //토큰으로부터 정보 추출
            String issuer = (String)jwtClaimMap.get("iss");                 // access token 발급자 추출
            String subject = (String)jwtClaimMap.get("sub");                // acess token 용도 추출

            // refresh token 검증 로직 시작
            return ((issuer.equals(issue)) && (subject.equals("refreshToken")));
        }
        // refresh token 만료 및 그외 에러시
        catch (Exception e) { return false;}
    }
}
