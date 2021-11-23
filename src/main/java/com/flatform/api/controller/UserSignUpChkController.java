package com.flatform.api.controller;

import com.flatform.api.service.UserSignUpChkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class UserSignUpChkController {

    @Autowired
    UserSignUpChkServiceImpl userSignUpchkServiceimpl;

    @ResponseBody
    @GetMapping(value="/users/member/check/{id}")
    public List memberCheckById(@PathVariable(name = "id") String requestedId)
    {
        List resultByService = userSignUpchkServiceimpl.checkId(requestedId);

        return resultByService;
    }



}
