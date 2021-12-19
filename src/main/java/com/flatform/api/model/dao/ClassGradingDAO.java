package com.flatform.api.model.dao;

import com.flatform.api.model.dto.ClassGradingDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface ClassGradingDAO {
    public boolean updateClassGrade(Map<String, Object> classgradingparam);
}
