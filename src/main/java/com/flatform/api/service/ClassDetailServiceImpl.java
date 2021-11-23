package com.flatform.api.service;

import com.flatform.api.model.dao.ClassDetailDAO;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ClassDetailService")
public class ClassDetailServiceImpl implements ClassDetailService {

    @Autowired
    ClassDetailDAO classDetailDAO;

    @Override
    public List getClassDetailService(String classId)
    {
        return classDetailDAO.getClassDetailListById(classId);
    }
}
