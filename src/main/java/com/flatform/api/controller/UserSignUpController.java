package com.flatform.api.controller;

import com.flatform.api.service.UserSignUpService;
import com.flatform.api.service.UserSignUpServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("")
public class UserSignUpController {

    @Autowired
    UserSignUpServiceImpl userSignUpServiceimpl;

/*
    @GetMapping(value="/users/member/check/{id}")
    public String memberCheckById(@PathVariable(name = "id") String requestedId)
    {
        String resultByService = userSignUpServiceimpl.checkId(requestedId);
        return resultByService;
    }
*/
    @GetMapping(value="/users/member/check/")
    public String test(){

        return "test";
    }


}
