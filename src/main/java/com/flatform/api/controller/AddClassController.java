package com.flatform.api.controller;

import com.flatform.api.model.dto.AddClassDTO;
import com.flatform.api.model.dto.ClassDetailDTO;
import com.flatform.api.service.AddClassServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AddClassController {

    @Autowired
    AddClassServiceImpl addClassService;

    @PostMapping("/class/new")
    public String addClassInfo(@RequestBody AddClassDTO addClassDTO)
    {
        String result = addClassService.addNewClass(addClassDTO);
        return result;
    }

}
