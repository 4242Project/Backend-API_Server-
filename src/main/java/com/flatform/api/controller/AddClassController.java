package com.flatform.api.controller;

import com.flatform.api.model.dto.AddClassDTO;

import com.flatform.api.service.AddClassServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 클래스를 개설하는 기능의 컨트롤러
@RestController
@RequestMapping("")
public class AddClassController {

    @Autowired
    AddClassServiceImpl addClassServiceimpl;

    @PostMapping("/class/new")
    public String addClassInfo(@RequestBody AddClassDTO addClassDTO)
    {
        return addClassServiceimpl.addNewClass(addClassDTO);
    }
}
