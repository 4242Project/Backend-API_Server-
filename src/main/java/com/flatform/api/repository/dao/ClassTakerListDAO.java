package com.flatform.api.repository.dao;

import com.flatform.api.repository.dto.ClassTakerListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassTakerListDAO {
    List<ClassTakerListDTO> getClassTakerListDB(String class_id);
}
