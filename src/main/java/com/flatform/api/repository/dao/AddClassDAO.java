package com.flatform.api.repository.dao;

import com.flatform.api.repository.dto.AddClassDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddClassDAO {
    boolean addNewClass(AddClassDTO addClassDTO);
    String getClassIdStd();
}
