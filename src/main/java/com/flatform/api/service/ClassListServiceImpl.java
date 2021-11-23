package com.flatform.api.service;

import com.flatform.api.model.dao.ClassListDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("ClassListByCatService")
public class ClassListServiceImpl implements ClassListService {

    @Autowired
    ClassListDAO classListDAO;

    @Override
    public List getClassListByCat(String univ_id, String cat_name){

        HashMap<String, Object> parammap = new HashMap<String, Object>();
        parammap.put("univ_id", univ_id);
        parammap.put("cat_name", cat_name);

        return classListDAO.getClassListByCat(parammap);
    }

    @Override
    public List getClassListByQuery(String univ_id, String Query){

        HashMap<String, Object> parammap = new HashMap<>();
        parammap.put("univ_id", univ_id);
        parammap.put("Query", Query);

        return classListDAO.getClassListByQuery(parammap);
    }
}