package com.flatform.api.Intercepor;

import com.flatform.api.security.TokenManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component // 클래스를 Bean 으로 등록
public class AccessInterceptor implements HandlerInterceptor
{
    private static final String ACCESS_HEADER_AUTH = "Access-Token";

    @Autowired
    private TokenManagement tokenManagement;

    @Override
    public boolean preHandle(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws Exception
    {
        String accTokenStr = request.getHeader(ACCESS_HEADER_AUTH);

        // access token 요청이 들어왔을 때
        if(accTokenStr != null)
        {
            // access token 검증 완료 시 컨트롤러 호출 가능
            if(tokenManagement.accessTokenVerify(accTokenStr))
            {
                return true;
            }
        }
        // access token 검증 실패 시 403 error 반환
        response.sendError(403, "Access Denied");

        return false;
    }
}
