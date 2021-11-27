package com.flatform.api.Intercepor;

import com.flatform.api.TokenMgmt.TokenManagement;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class CertificationInterceptor {

    @Autowired
    private TokenManagement tokenManagement;

    //@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception{
        HttpSession session = request.getSession();
        //작성 중
        return true;

    }
}
