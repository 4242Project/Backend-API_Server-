package com.flatform.api.controller;

import com.flatform.api.model.dto.ClassListDTO;
import com.flatform.api.service.ClassListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class ClassListByCatController {

    @Autowired
    ClassListServiceImpl classListServiceImpl;

    @ResponseBody
    @GetMapping(value="/class/list/{univ_id}/{category_id}")
    public List<ClassListDTO> getClassesListByCat(@PathVariable(name="univ_id") String univ_id,
                                                  @PathVariable(name="category_id") String cat_id)
    {
        return classListServiceImpl.getClassListByCat(univ_id, cat_id);
    }
}
