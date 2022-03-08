package com.flatform.api.controller;

import com.flatform.api.model.dto.ClassListDTO;
import com.flatform.api.service.ClassListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//검색 키워드를 기준으로 클래스 목록을 조회하는 기능의 컨트롤러
@RestController
@RequestMapping("")
public class ClassListBySearchQueryController
{
    @Autowired
    ClassListServiceImpl classListServiceImpl;

    @ResponseBody
    @GetMapping(value="/class/search/{univ_id}/search")
    public List<ClassListDTO> getClassesListByCat(@PathVariable(name="univ_id") String univ_id, @RequestParam(value="query") String Query)
    {
        return classListServiceImpl.getClassListByQuery(univ_id, Query);
    }
}