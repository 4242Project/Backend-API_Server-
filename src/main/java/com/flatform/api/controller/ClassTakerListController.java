package com.flatform.api.controller;


import com.flatform.api.model.dto.ClassTakerListDTO;
import com.flatform.api.service.ClassTakerListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class ClassTakerListController {

    @Autowired
    ClassTakerListServiceImpl classTakerListServiceimpl;

    @ResponseBody
    @GetMapping(value="class/peer-list/{class_id}")
    public List<ClassTakerListDTO> getClassTaker(@PathVariable(name = "class_id") String class_id)
    {
        return classTakerListServiceimpl.getClasstakerList(class_id);
    }
}
