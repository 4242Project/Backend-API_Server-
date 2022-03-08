package com.flatform.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class ConnectionTestController
{
    @ResponseBody
    @GetMapping(value = "/api/test")
    public String apiServerConnectionTest()
    {
        return "Server Connection OK!! Replied by ConnectionTestController Class.";
    }
}
