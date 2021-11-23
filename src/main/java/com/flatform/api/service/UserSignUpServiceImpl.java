package com.flatform.api.service;

import com.flatform.api.model.dao.UserSignUpDAO;
import com.flatform.api.model.dto.UserSignUpDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserSignUpService")
@RequiredArgsConstructor
public class UserSignUpServiceImpl implements UserSignUpService{

    @Autowired
    UserSignUpDAO userSignUpDAO;

    @Override
    public void createUser(UserSignUpDTO userSignUpDTO)
    {
        userSignUpDAO.userSignUp(userSignUpDTO);
    }

}
