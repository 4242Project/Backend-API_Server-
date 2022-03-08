package com.flatform.api.controller;

import com.flatform.api.model.dto.RefreshTokenDTO;
import com.flatform.api.service.LookupUserRefreshTokenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// 회원의 엑세스 토큰을 재발급하는 기능의 컨트롤러
@RestController
@RequestMapping("")
// 엑세스 토큰 만료(만료 임박 시) 리프레시 토큰을 수신 후 엑세스 토큰 재발급
public class UpdateAccessTokenController
{
    @Autowired
    LookupUserRefreshTokenServiceImpl lookupUserRefreshTokenService;

    @PostMapping("/auth/token/update")
    public List<Object> updateAccessToken(@RequestBody RefreshTokenDTO refreshTokenDTO)
    {
        // 리프레시 토큰을 받아서 서비스 호출
        // 서비스는 갱신된 엑세스 토큰 반환
        return lookupUserRefreshTokenService.getNewAccessToken(refreshTokenDTO.getRefreshTokenValue(), refreshTokenDTO.getUserID());
    }
}
