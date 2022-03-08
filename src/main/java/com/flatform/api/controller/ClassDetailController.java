package com.flatform.api.controller;

import com.flatform.api.model.dto.ClassDetailDTO;
import com.flatform.api.service.ClassDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// 특정 클래스의 세부사항을 조회하는 기능의 컨트롤러
@RestController
@RequestMapping("")
public class ClassDetailController
{
    @Autowired
    ClassDetailServiceImpl classDetailServiceImpl;

    @ResponseBody
    @GetMapping(value = "/class/detail/{class_id}")
    public List<ClassDetailDTO> getClassDetailById(@PathVariable(name = "class_id") String classId)
    {
        return classDetailServiceImpl.getClassDetailService(classId);
    }
}
