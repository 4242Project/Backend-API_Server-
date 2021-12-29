package com.flatform.api.model.dao;

import com.flatform.api.model.dto.AllClassMemberTakeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AllClassMemberTakeDAO
{
    List<AllClassMemberTakeDTO> getAllClassMemberTake(String member_id);
}
