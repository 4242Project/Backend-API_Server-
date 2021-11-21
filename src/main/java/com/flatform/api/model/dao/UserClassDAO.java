package com.flatform.api.model.dao;

import com.flatform.api.model.dto.UserClassDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface UserClassDAO {
    public List<UserClassDTO> getTodayClass(HashMap<String, Object> map);
}
