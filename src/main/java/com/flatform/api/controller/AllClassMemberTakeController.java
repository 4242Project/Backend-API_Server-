package com.flatform.api.controller;

import com.flatform.api.model.dto.AllClassMemberTakeDTO;
import com.flatform.api.service.AllClassMemberTakeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//회원이 수강하는 클래스 목록을 조회하는 컨트롤러
@RestController
@RequestMapping("")
public class AllClassMemberTakeController
{
    @Autowired
    AllClassMemberTakeServiceImpl allClassMemberTakeServiceImpl;

    @ResponseBody
    @GetMapping(value = "/class/member/list/{member_id}")
    public List<AllClassMemberTakeDTO> getAllClassMemberTake(@PathVariable(name="member_id")String member_id)
    {
        return allClassMemberTakeServiceImpl.allClassMemberTake(member_id);
    }
}
