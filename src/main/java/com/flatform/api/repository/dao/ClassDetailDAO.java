package com.flatform.api.repository.dao;

import com.flatform.api.repository.dto.ClassDetailDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassDetailDAO {
    List<ClassDetailDTO> getClassDetailListById(String classId);
}
