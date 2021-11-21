package com.flatform.api.service;

import com.flatform.api.model.dao.UserClassDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("UserClassService")
public class UserClassServiceImpl implements UserClassService {

    @Autowired
    UserClassDAO userClassDAO;

    @Override
    public List getUserTodayClass(String userId, int date){

        HashMap<String, Object> parammap = new HashMap<String, Object>(); //다중 파라미터를 받기위한 코드
        parammap.put("userId", userId);
        parammap.put("date", date);
        System.out.println(parammap);

        return userClassDAO.getTodayClass(parammap);
    }
}
