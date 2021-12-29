package com.flatform.api.controller;

import com.flatform.api.model.dto.ClassGradingDTO;
import com.flatform.api.service.ClassGradingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class ClassGradingController
{
    @Autowired
    ClassGradingServiceImpl classGtadingServiceimpl;

    @PatchMapping("/class/evaluate")
    public String classGrading(@RequestBody ClassGradingDTO classGradingDTO)
    {
        return classGtadingServiceimpl.classGradingService(classGradingDTO);
    }


}
