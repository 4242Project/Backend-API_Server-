package com.flatform.api.repository.dao;

import com.flatform.api.repository.dto.EnrollClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollClassRepository extends JpaRepository<EnrollClassEntity, String>{
}
