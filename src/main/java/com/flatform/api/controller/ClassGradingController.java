package com.flatform.api.controller;

import com.flatform.api.model.dto.ClassGradingDTO;
import com.flatform.api.service.ClassGradingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//클래스의 점수를 책정하는 기능의 컨트롤러
@RestController
@RequestMapping("")
public class ClassGradingController
{
    @Autowired
    ClassGradingServiceImpl classGradingServiceimpl;

    @PatchMapping("/class/evaluate")
    public String classGrading(@RequestBody ClassGradingDTO classGradingDTO)
    {
        return classGradingServiceimpl.classGradingService(classGradingDTO);
    }

}
