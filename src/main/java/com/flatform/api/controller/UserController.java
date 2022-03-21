package com.flatform.api.controller;

import com.flatform.api.repository.dto.MemberStampNumDTO;
import com.flatform.api.repository.dto.UserInfoEntity;
import com.flatform.api.repository.dto.UserLoginDTO;
import com.flatform.api.repository.dto.tokenMapping;
import com.flatform.api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// 회원의 카테고리별 도장 개수를 조회하는 기능의 컨트롤러
@RestController
@RequestMapping("")
public class UserController
{
    @Autowired
    UserService userService;

    @ResponseBody
    @GetMapping(value = "/stamp/{id}")
    public Optional<MemberStampNumDTO> memberStampNumber(@PathVariable(name = "id") String member_id)
    {
        return userService.getMemberStampNumber(member_id);
    }


    // 로그인 기능을 수행하는 컨트롤러
    @PostMapping("/users/member/login")
    public List<Object> userLigin(@RequestBody UserLoginDTO userLoginDTO)
    {
        Map<String, Object> loginReturnObj;
        // 로그인 결과를 얻어온다.
        loginReturnObj = userService.verifyUser(userLoginDTO);

        List<Object> result = new ArrayList<>();
        result.add(loginReturnObj);

        //로그인 결과를 반환한다.
        return result;
    }

    // 회원가입 시 이미 가입된 회원이 있는지 확인하는 기능 컨트롤러
    @ResponseBody
    @GetMapping(value="/users/member/check/{id}")
    public List<Object> memberCheckById(@PathVariable(name = "id") String requestedId)
    {
        return userService.checkId(requestedId);
    }


    // 회원가입을 수행하는 컨트롤러
    @PostMapping("/users/member/new")
    public List<Object> createUserData(@RequestBody UserInfoEntity userSignUpEntity)
    {
        Map<String, String> signUpReturnObj;
        signUpReturnObj = userService.createUser(userSignUpEntity);

        //회원가입 결과 정보를 저장하고 리턴
        List<Object> result = new ArrayList<>();
        result.add(signUpReturnObj);

        return result;
    }


    // 회원의 엑세스 토큰을 재발급하는 기능의 컨트롤러
    // 엑세스 토큰 만료(만료 임박 시) 리프레시 토큰을 수신 후 엑세스 토큰 재발급

    @PostMapping("/auth/token/update")
    public List<Object> updateAccessToken(@RequestBody tokenMapping TokenMapping)
    {
        // 리프레시 토큰을 받아서 서비스 호출
        // 서비스는 갱신된 엑세스 토큰 반환
        return userService.getNewAccessToken(TokenMapping.getRefreshToken(), TokenMapping.getId());
    }
}
