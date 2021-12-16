package com.flatform.api.controller;

import com.flatform.api.model.dto.UserSignUpDTO;
import com.flatform.api.service.UserSignUpChkServiceImpl;
import com.flatform.api.service.UserSignUpService;
import com.flatform.api.service.UserSignUpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("")
public class UserSignUpController {

    @Autowired
    UserSignUpServiceImpl userSignUpServiceImpl;

    @PostMapping("/users/member/new")
    public Map createUserData(@RequestBody UserSignUpDTO userSignUpDTO)
    {
        Map<String, Object> signUpResult = new HashMap<>();
        signUpResult = userSignUpServiceImpl.createUser(userSignUpDTO);


        return signUpResult;
    }

}
