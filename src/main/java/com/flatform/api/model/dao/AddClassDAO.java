package com.flatform.api.model.dao;

import com.flatform.api.model.dto.AddClassDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddClassDAO {
    boolean addNewClass(AddClassDTO addClassDTO);
    String getClassIdStd();
}
