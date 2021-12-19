package com.flatform.api.controller;

import com.flatform.api.model.dto.EnrollClassDTO;
import com.flatform.api.service.EnrollClassServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("")
public class EnrollClassController {

    @Autowired
    EnrollClassServiceImpl enrollClassServiceImpl;

    @PostMapping("/class/enrolling")
    public ArrayList classEnrolling(@RequestBody EnrollClassDTO enrollClassDTO)
    {
        enrollClassServiceImpl.enrollClass(enrollClassDTO);
        ArrayList result = new ArrayList<>();
        result.add("OK");

        return result;
    }
}
