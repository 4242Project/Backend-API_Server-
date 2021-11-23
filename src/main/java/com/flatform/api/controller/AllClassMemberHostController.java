package com.flatform.api.controller;

import com.flatform.api.service.AllClassMemberHostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class AllClassMemberHostController
{
    @Autowired
    AllClassMemberHostServiceImpl allClassMemberHostServiceImpl;

    @ResponseBody
    @GetMapping(value = "/class/open/{member_id}")
    public List getAllClssesMemberHost(@PathVariable (name="member_id")String member_id)
    {
        return allClassMemberHostServiceImpl.getAllClassMemberHost(member_id);
    }
}
