package com.flatform.api.repository.dao;

import com.flatform.api.repository.dto.AllClassMemberTakeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AllClassMemberTakeDAO
{
    List<AllClassMemberTakeDTO> getAllClassMemberTake(String member_id);
}
