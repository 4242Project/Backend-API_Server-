package com.flatform.api.controller;

import com.flatform.api.model.dto.UserLoginDTO;
import com.flatform.api.service.UserLoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// 로그인 기능을 수행하는 컨트롤러
@RestController
@RequestMapping("")
public class UserLoginController
{
    @Autowired
    UserLoginServiceImpl userLoginserviceImpl;

    @PostMapping("/users/member/login")
    public List<Object> userLigin(@RequestBody UserLoginDTO userLoginDTO)
    {
        Map<String, Object> loginReturnObj;
        // 로그인 결과를 얻어온다.
        loginReturnObj = userLoginserviceImpl.verifyUser(userLoginDTO);

        List<Object> result = new ArrayList<>();
        result.add(loginReturnObj);

        //로그인 결과를 반환한다.
        return result;
    }
}
