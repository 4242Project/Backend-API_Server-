package com.flatform.api.model.dao;

import com.flatform.api.model.dto.ClassListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ClassListDAO {
    List<ClassListDTO> getClassListByCat(HashMap<String, Object> map);
    List<ClassListDTO> getClassListByQuery(HashMap<String, Object>map);
}
