package com.flatform.api.controller;

import com.flatform.api.model.dto.ClassListDTO;
import com.flatform.api.service.ClassListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// 카테고리를 기준으로 클래스 목록을 조회해주는 기능의 컨트롤러
@RestController
@RequestMapping("")
public class ClassListByCatController
{
    @Autowired
    ClassListServiceImpl classListServiceImpl;

    @ResponseBody
    @GetMapping(value="/class/list/{univ_id}/{category_id}")
    public List<ClassListDTO> getClassesListByCat(@PathVariable(name="univ_id") String univ_id, @PathVariable(name="category_id") String cat_id)
    {
        return classListServiceImpl.getClassListByCat(univ_id, cat_id);
    }
}
