package com.flatform.api.controller;

import com.flatform.api.model.dto.MemberStampNumDTO;
import com.flatform.api.service.MemberStampNumServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// 회원의 카테고리별 도장 개수를 조회하는 기능의 컨트롤러
@RestController
@RequestMapping("")
public class MemberStampNumController
{
    @Autowired
    MemberStampNumServiceImpl memberStampNumServiceimpl;

    @ResponseBody
    @GetMapping(value = "/stamp/{id}")
    public List<MemberStampNumDTO> memberStampNumber(@PathVariable(name = "id") String member_id)
    {
        return memberStampNumServiceimpl.getMemberStampNumber(member_id);
    }
}
