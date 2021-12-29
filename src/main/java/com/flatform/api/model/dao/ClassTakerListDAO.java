package com.flatform.api.model.dao;

import com.flatform.api.model.dto.ClassTakerListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassTakerListDAO {
    List<ClassTakerListDTO> getClassTakerListDB(String class_id);
}
