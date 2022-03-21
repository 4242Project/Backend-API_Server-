package com.flatform.api.repository.dao;

import com.flatform.api.repository.dto.MemberStampNumDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberStampNumDAO {
    Optional<MemberStampNumDTO> getMemberStampNum(String member_id);
}
