package com.flatform.api.controller;

import com.flatform.api.service.ClassTakerListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class ClassTakerListController {

    @Autowired
    ClassTakerListServiceImpl classTakerServiceImpl;

    @ResponseBody
    @GetMapping(value = "/class/per-lists/{class_id}")
    public List getClassTakerLists(@PathVariable(name = "class_id") String classId)
    {
        return classTakerServiceImpl.getClassTakerList(classId);
    }
}
