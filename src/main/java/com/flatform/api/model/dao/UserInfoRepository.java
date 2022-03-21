package com.flatform.api.model.dao;

import com.flatform.api.model.dto.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfoEntity, String> {
}
