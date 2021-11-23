package com.flatform.api.service;

import com.flatform.api.model.dao.MemberStampNumDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("MemberStampNumService")
public class MemberStampNumServiceImpl implements MemberStampNumService{

    @Autowired
    MemberStampNumDAO memberStampNumDAO;

    @Override
    public List getMemberStampNumber(String member_id)
    {
        return memberStampNumDAO.getMemberStampNum(member_id);
    }
}
