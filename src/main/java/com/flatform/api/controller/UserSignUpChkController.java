package com.flatform.api.controller;

import com.flatform.api.service.UserSignUpChkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// 회원가입 시 이미 가입된 회원이 있는지 확인하는 기능 컨트롤러
@RestController
@RequestMapping("")
public class UserSignUpChkController
{
    @Autowired
    UserSignUpChkServiceImpl userSignUpchkServiceimpl;

    @ResponseBody
    @GetMapping(value="/users/member/check/{id}")
    public List<Object> memberCheckById(@PathVariable(name = "id") String requestedId)
    {
        return userSignUpchkServiceimpl.checkId(requestedId);
    }
}
