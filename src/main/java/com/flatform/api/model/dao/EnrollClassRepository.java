package com.flatform.api.model.dao;

import com.flatform.api.model.dto.EnrollClassEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollClassRepository extends JpaRepository<EnrollClassEntity, String>{
}
