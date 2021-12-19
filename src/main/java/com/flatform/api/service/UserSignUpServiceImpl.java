package com.flatform.api.service;

import com.flatform.api.TokenMgmt.TokenManagement;
import com.flatform.api.model.dao.UserSignUpDAO;
import com.flatform.api.model.dto.UserSignUpDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("UserSignUpService")
@RequiredArgsConstructor
public class UserSignUpServiceImpl implements UserSignUpService{

    @Autowired
    UserSignUpDAO userSignUpDAO;

    @Autowired
    TokenManagement tokenManagement;

    @Override
    public Map createUser(UserSignUpDTO userSignUpDTO)
    {
        //회원가입 정보로부터 id 값 추출
        String memberId = userSignUpDTO.getId();

        //ID값 정보로부터 ACCESS Token, Refresh Token 발급
        String newaccesstkn = tokenManagement.generateAccessToken(memberId);
        String newrefreshtkn = tokenManagement.generateRefreshToken(memberId);
        //userSignUp  DTO 에 발급한 리프레시 트콘 넣기
        userSignUpDTO.setRefreshtoken(newrefreshtkn);

        //DB에 회원정보 넣기
        userSignUpDAO.userSignUp(userSignUpDTO);

        // 발급한 access token, refresh token 을 Controller에게 return
        Map<String, String> tokenTable = new HashMap<>();
        tokenTable.put("SIGNUP_STATUS", "SUCCESS");
        tokenTable.put("ACCESS_TOKEN", newaccesstkn);
        tokenTable.put("REFRESH_TOKEN", newrefreshtkn);

        return tokenTable;

    }

}
