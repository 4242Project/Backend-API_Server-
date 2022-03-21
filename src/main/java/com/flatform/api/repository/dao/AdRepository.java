package com.flatform.api.repository.dao;

import com.flatform.api.repository.dto.AdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdRepository extends JpaRepository<AdEntity, String> {
}
