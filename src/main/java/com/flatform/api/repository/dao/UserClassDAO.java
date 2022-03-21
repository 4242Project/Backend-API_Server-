package com.flatform.api.repository.dao;

import com.flatform.api.repository.dto.UserClassDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface UserClassDAO {
    List<UserClassDTO> getTodayClass(HashMap<String, Object> map);
}
