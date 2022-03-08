package com.flatform.api.controller;


import com.flatform.api.model.dto.ClassTakerListDTO;
import com.flatform.api.service.ClassTakerListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//특정 클래스의 수강생 목록을 조회하는 기능의 컨트롤러
@RestController
@RequestMapping("")
public class ClassTakerListController
{
    @Autowired
    ClassTakerListServiceImpl classTakerListServiceimpl;

    @ResponseBody
    @GetMapping(value="class/peer-list/{class_id}")
    public List<ClassTakerListDTO> getClassTaker(@PathVariable(name = "class_id") String class_id)
    {
        return classTakerListServiceimpl.getClasstakerList(class_id);
    }
}
