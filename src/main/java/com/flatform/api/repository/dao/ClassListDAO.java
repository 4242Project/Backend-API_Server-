package com.flatform.api.repository.dao;

import com.flatform.api.repository.dto.ClassListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ClassListDAO {
    List<ClassListDTO> getClassListByCat(HashMap<String, Object> map);
    List<ClassListDTO> getClassListByQuery(HashMap<String, Object>map);
}
