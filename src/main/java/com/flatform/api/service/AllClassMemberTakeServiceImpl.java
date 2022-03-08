package com.flatform.api.service;

import com.flatform.api.model.dao.AllClassMemberTakeDAO;
import com.flatform.api.model.dto.AllClassMemberTakeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AllClassMemberTakeService")
public class AllClassMemberTakeServiceImpl implements AllClassMemberTakeService
{

    @Autowired
    AllClassMemberTakeDAO allClassMemberTakeDAO;

    @Override
    public List<AllClassMemberTakeDTO> allClassMemberTake(String member_id)
    {
        return allClassMemberTakeDAO.getAllClassMemberTake(member_id);
    }
}
