package com.flatform.api.controller;

import com.flatform.api.service.UserClassServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Calendar;

@RestController
@RequestMapping("")
public class UserClassController {

    @Autowired
    UserClassServiceImpl userClassServiceimpl;

    @ResponseBody
    @GetMapping(value="/class/member/today/{id}")
    public List getTodayClasses(@PathVariable(name = "id") String requestedId){
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        return userClassServiceimpl.getUserTodayClass(requestedId, calendar.get(Calendar.DAY_OF_WEEK));
    }

}
