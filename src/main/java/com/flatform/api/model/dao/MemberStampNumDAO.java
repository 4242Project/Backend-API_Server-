package com.flatform.api.model.dao;

import com.flatform.api.model.dto.MemberStampNumDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberStampNumDAO {
    Optional<MemberStampNumDTO> getMemberStampNum(String member_id);
}
