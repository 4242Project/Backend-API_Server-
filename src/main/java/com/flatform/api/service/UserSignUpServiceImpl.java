package com.flatform.api.service;

import com.flatform.api.model.dao.UserSignUpChkDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("UserSignUpService")

public class UserSignUpServiceImpl implements UserSignUpService {

    @Autowired
    UserSignUpChkDAO userSignUpChkDAO;


    @Override
    public List checkId(String targetId){
        return userSignUpChkDAO.searchId(targetId);

    }


}
