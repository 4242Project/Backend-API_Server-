package com.flatform.api.service;

import com.flatform.api.model.dao.AllClassMemberHostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AllClassMemberHostService")
public class AllClassMemberHostServiceImpl implements AllClassMemberHostService{

    @Autowired
    AllClassMemberHostDAO allClassMemberHostDAO;

    @Override
    public List getAllClassMemberHost(String member_id)
    {
        return allClassMemberHostDAO.getAllClassMemberHost(member_id);
    }
}
