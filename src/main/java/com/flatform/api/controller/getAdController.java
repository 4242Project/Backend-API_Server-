package com.flatform.api.controller;

import com.flatform.api.model.dao.AdRepository;
import com.flatform.api.model.dto.AdEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

// 앱 화면에 표시할 광고 정보를 가져오는 기능의 컨트롤러
@RestController
@RequestMapping("")
public class getAdController
{
    //광고정보 가져오기
    @Autowired
    AdRepository adRepository;

    @ResponseBody
    @GetMapping(value = "/ad/lists")
    public List<AdEntity> getAdLists()
    {
        return adRepository.findAll();
    }
}
