package com.flatform.api.repository.dao;

import com.flatform.api.repository.dto.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfoEntity, String> {
}
