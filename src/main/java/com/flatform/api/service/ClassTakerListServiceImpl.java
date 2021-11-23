package com.flatform.api.service;

import com.flatform.api.model.dao.ClassTakerListDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ClassTakerListService")
public class ClassTakerListServiceImpl implements ClassTakerListService{

    @Autowired
    ClassTakerListDAO classTakerListDAO;

    @Override
    public List getClassTakerList(String class_id)
    {
        List takerlist =  classTakerListDAO.getClassTakerListData(class_id);
        //id 값 가져온다음에 getMemberStampTop3 호출 후 병합
        return takerlist;
    }
}
