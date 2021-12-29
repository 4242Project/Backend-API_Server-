package com.flatform.api.service;

import com.flatform.api.model.dao.UserSignUpChkDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service("UserSignUpChkService")

public class UserSignUpChkServiceImpl implements UserSignUpChkService {

    @Autowired
    UserSignUpChkDAO userSignUpChkDAO;


    @Override
    public List<Object> checkId(String targetId){
        boolean idChk =  userSignUpChkDAO.searchId(targetId);
        ArrayList<Object> result = new ArrayList<>();

        HashMap<String, Object> data = new HashMap<>();

        data.put("check", idChk);
        result.add(data);

        return result;
    }


}
