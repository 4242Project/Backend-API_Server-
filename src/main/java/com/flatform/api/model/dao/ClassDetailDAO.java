package com.flatform.api.model.dao;

import com.flatform.api.model.dto.ClassDetailDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassDetailDAO {
    public List<ClassDetailDTO> getClassDetailListById(String classId);
}
