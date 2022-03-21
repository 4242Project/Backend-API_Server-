package com.flatform.api.model.dao;

import com.flatform.api.model.dto.AllClassMemberHostEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AllClassMemberHostRepository extends JpaRepository<AllClassMemberHostEntity, String> {
    List<AllClassMemberHostEntity> findByHostId(String member_id);
}
