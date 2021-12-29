package com.flatform.api.service;

import com.flatform.api.model.dao.ClassTakerListDAO;
import com.flatform.api.model.dto.ClassTakerListDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ClassTakerListService")
public class ClassTakerListServiceImpl implements ClassTakerListService {

    @Autowired
    ClassTakerListDAO classTakerListDAO;

    @Override
    public List<ClassTakerListDTO> getClasstakerList(String class_id)
    {
        return classTakerListDAO.getClassTakerListDB(class_id);

    }
}
