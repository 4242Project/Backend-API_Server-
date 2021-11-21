package com.flatform.api.service;

import com.flatform.api.model.dao.UserSignUpDAO;
import com.flatform.api.model.dto.UserSignUpDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserSignUpService")

public class UserSignUpServiceImpl implements UserSignUpService {

    @Autowired
    UserSignUpDAO userSignUpDAO;


    @Override
    public String checkId(String targetId){
        return userSignUpDAO.searchId(targetId);
    }


}
