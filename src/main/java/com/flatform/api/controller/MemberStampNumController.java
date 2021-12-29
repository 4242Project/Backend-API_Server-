package com.flatform.api.controller;

import com.flatform.api.model.dto.MemberStampNumDTO;
import com.flatform.api.service.MemberStampNumServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class MemberStampNumController {

    @Autowired
    MemberStampNumServiceImpl memberStampNumServiceimpl;

    @ResponseBody
    @GetMapping(value = "/stamp/{id}")
    public List<MemberStampNumDTO> memberStampNumber(@PathVariable(name = "id") String member_id)
    {
        return memberStampNumServiceimpl.getMemberStampNumber(member_id);
    }
}
