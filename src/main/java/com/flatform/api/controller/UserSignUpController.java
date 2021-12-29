package com.flatform.api.controller;

import com.flatform.api.model.dto.UserSignUpDTO;
import com.flatform.api.service.UserSignUpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("")
public class UserSignUpController {

    @Autowired
    UserSignUpServiceImpl userSignUpServiceImpl;

    @PostMapping("/users/member/new")
    public List<Object> createUserData(@RequestBody UserSignUpDTO userSignUpDTO)
    {
        Map<String, String> signUpReturnObj;
        signUpReturnObj = userSignUpServiceImpl.createUser(userSignUpDTO);

        List<Object> result = new ArrayList<>();

        result.add(signUpReturnObj);

        return result;
    }

}
