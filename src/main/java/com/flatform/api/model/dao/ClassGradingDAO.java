package com.flatform.api.model.dao;

import org.apache.ibatis.annotations.Mapper;
import java.util.Map;

@Mapper
public interface ClassGradingDAO {
    boolean updateClassGrade(Map<String, Object> classgradingparam);
}
