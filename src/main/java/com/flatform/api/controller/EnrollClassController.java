package com.flatform.api.controller;

import com.flatform.api.model.dto.EnrollClassDTO;
import com.flatform.api.service.EnrollClassServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

// 클래스 수강 신청하는 기능의 컨트롤러
@RestController
@RequestMapping("")
public class EnrollClassController
{
    @Autowired
    EnrollClassServiceImpl enrollClassServiceImpl;

    @PostMapping("/class/enrolling")
    public ArrayList<String> classEnrolling(@RequestBody EnrollClassDTO enrollClassDTO)
    {
        enrollClassServiceImpl.enrollClass(enrollClassDTO);
        ArrayList<String> result = new ArrayList<>();
        result.add("OK");

        return result;
    }
}
