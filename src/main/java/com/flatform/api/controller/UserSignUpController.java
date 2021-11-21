package com.flatform.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flatform.api.service.UserSignUpService;
import com.flatform.api.service.UserSignUpServiceImpl;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("")
public class UserSignUpController {

    @Autowired
    UserSignUpServiceImpl userSignUpServiceimpl;

    @ResponseBody
    @GetMapping(value="/users/member/check/{id}")
    public List memberCheckById(@PathVariable(name = "id") String requestedId)
    {
        List resultByService = userSignUpServiceimpl.checkId(requestedId);

        return resultByService;
    }



}
