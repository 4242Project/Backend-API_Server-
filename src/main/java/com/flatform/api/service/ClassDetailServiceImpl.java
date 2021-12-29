package com.flatform.api.service;

import com.flatform.api.model.dao.ClassDetailDAO;
import com.flatform.api.model.dto.ClassDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ClassDetailService")
public class ClassDetailServiceImpl implements ClassDetailService {

    @Autowired
    ClassDetailDAO classDetailDAO;

    @Override
    public List<ClassDetailDTO> getClassDetailService(String classId)
    {
        //String res = classDetailDAO.getClassDetailListById(classId);
        return classDetailDAO.getClassDetailListById(classId);
    }
}
