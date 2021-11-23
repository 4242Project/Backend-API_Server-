package com.flatform.api.model.dao;

import com.flatform.api.model.dto.EnrollClassDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface EnrollClassDAO {
    public void enroll(EnrollClassDTO enrollClassDTO);
}
