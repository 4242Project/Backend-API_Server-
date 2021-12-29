package com.flatform.api.model.dao;

import com.flatform.api.model.dto.AllClassMemberHostDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AllClassMemberHostDAO {
    List<AllClassMemberHostDTO> getAllClassMemberHost(String member_id);
}
