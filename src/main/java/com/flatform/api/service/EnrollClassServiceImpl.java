package com.flatform.api.service;

import com.flatform.api.model.dao.EnrollClassDAO;
import com.flatform.api.model.dto.EnrollClassDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("EnrollClassService")
@RequiredArgsConstructor
public class EnrollClassServiceImpl implements EnrollClassService{

    @Autowired
    EnrollClassDAO enrollClassDAO;

    @Override
    public void enrollClass(EnrollClassDTO enrollClassDTO)
    {
        enrollClassDAO.enroll(enrollClassDTO);
    }
}
