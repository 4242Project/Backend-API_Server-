package com.flatform.api.model.dao;

import com.flatform.api.model.dto.MemberStampNumDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberStampNumDAO {
    public List<MemberStampNumDTO> getMemberStampNum(String member_id);
}
