package com.flatform.api.Intercepor;

import com.flatform.api.TokenMgmt.TokenManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component // 클래스를 Bean으로 등록
public class AcessInterceptor implements HandlerInterceptor {

    private static final String ACCESS_HEADER_AUTH = "Acess-Token";

    @Autowired
    private TokenManagement tokenManagement;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        String accTokenStr = request.getHeader(ACCESS_HEADER_AUTH);
        if(accTokenStr != null)                                         // access token 요청이 들어왔을 때
        {
            if(tokenManagement.accessTokenVerify(accTokenStr))          // access token 검증 완료 시 컨트롤러 호출 가능
            {
                return true;
            }
        }
        response.sendError(403, "Access Denied");                  // access token 검증 실패 시 403 error 반환

        return false;
    }

}
