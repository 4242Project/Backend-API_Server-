package com.flatform.api.controller;

import com.flatform.api.model.dao.AdDAO;
import com.flatform.api.model.dto.AdDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class getAdController {
    //광고정보 가져오기는 service 레이어를 거치지 않음
    @Autowired
    AdDAO adDAO;

    @ResponseBody
    @GetMapping(value = "/ad/lists")
    public List<AdDTO> getAdLists()
    {
        return adDAO.getAdInfo();
    }

}
