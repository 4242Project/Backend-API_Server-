package com.flatform.api.service;

import com.flatform.api.model.dao.MemberStampNumDAO;
import com.flatform.api.model.dto.MemberStampNumDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("MemberStampNumService")
public class MemberStampNumServiceImpl implements MemberStampNumService{

    @Autowired
    MemberStampNumDAO memberStampNumDAO;

    @Override
    public List<MemberStampNumDTO> getMemberStampNumber(String member_id)
    {
        return memberStampNumDAO.getMemberStampNum(member_id);
    }
}
