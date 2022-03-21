package com.flatform.api.controller;

import com.flatform.api.model.dto.*;

import com.flatform.api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

// 클래스를 개설하는 기능의 컨트롤러
@RestController
@RequestMapping("")
public class ClassController {

    //회원이 개설한 클래스 목록을 조회하는 기능의 컨트롤러
    @Autowired
    ClassService classService;

    @ResponseBody
    @GetMapping(value = "/class/open/{member_id}")
    public List<AllClassMemberHostEntity> getAllClassesMemberHost(@PathVariable (name="member_id")String member_id)
    {
        return classService.getAllClassMemberHost(member_id);
    }


    // 카테고리를 기준으로 클래스 목록을 조회해주는 기능의 컨트롤러
    @ResponseBody
    @GetMapping(value="/class/list/{univ_id}/{category_id}")
    public List<ClassListDTO> getClassesListByCat(@PathVariable(name="univ_id") String univ_id, @PathVariable(name="category_id") String cat_id)
    {
        return classService.getClassListByCat(univ_id, cat_id);
    }

    //검색 키워드를 기준으로 클래스 목록을 조회하는 기능의 컨트롤러
    @ResponseBody
    @GetMapping(value="/class/search/{univ_id}/search")
    public List<ClassListDTO> getClassesListByQuery(@PathVariable(name="univ_id") String univ_id, @RequestParam(value="query") String Query)
    {
        return classService.getClassListByQuery(univ_id, Query);
    }


    //회원이 수강하는 클래스 목록을 조회하는 컨트롤러
    @ResponseBody
    @GetMapping(value = "/class/member/list/{member_id}")
    public List<AllClassMemberTakeDTO> getAllClassMemberTake(@PathVariable(name="member_id")String member_id)
    {
        return classService.allClassMemberTake(member_id);
    }


    // 특정 클래스의 세부사항을 조회하는 기능의 컨트롤러
    @Autowired
    ClassService classDetailServiceImpl;

    @ResponseBody
    @GetMapping(value = "/class/detail/{class_id}")
    public List<ClassDetailDTO> getClassDetailById(@PathVariable(name = "class_id") String classId)
    {
        return classDetailServiceImpl.getClassDetailService(classId);
    }


    //특정 클래스의 수강생 목록을 조회하는 기능의 컨트롤러
    @ResponseBody
    @GetMapping(value="class/peer-list/{class_id}")
    public List<ClassTakerListDTO> getClassTaker(@PathVariable(name = "class_id") String class_id)
    {
        return classService.getClasstakerList(class_id);
    }

    // 회원이 오늘 수강하는 클래스를 조회하는 컨트롤러
    @ResponseBody
    @GetMapping(value="/class/member/today/{id}")
    public List<UserClassDTO> getTodayClasses(@PathVariable(name = "id") String requestedId)
    {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        return classService.getUserTodayClass(requestedId, calendar.get(Calendar.DAY_OF_WEEK));
    }


    // 클래스를 개설하는 기능의 컨트롤러
    @PostMapping("/class/new")
    public String addClassInfo(@RequestBody AddClassDTO addClassDTO)
    {
        return classService.addNewClass(addClassDTO);
    }


    //클래스의 점수를 책정하는 기능의 컨트롤러
    @PatchMapping("/class/evaluate")
    public String classGrading(@RequestBody ClassGradingDTO classGradingDTO)
    {
        return classService.classGradingService(classGradingDTO);
    }

    // 클래스 수강 신청하는 기능의 컨트롤러
    @PostMapping("/class/enrolling")
    public ArrayList<String> classEnrolling(@RequestBody EnrollClassEntity enrollClassDTO)
    {
        classService.enrollClass(enrollClassDTO);
        ArrayList<String> result = new ArrayList<>();
        result.add("OK");

        return result;
    }
}
