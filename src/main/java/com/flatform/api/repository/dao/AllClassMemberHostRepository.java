package com.flatform.api.repository.dao;

import com.flatform.api.repository.dto.AllClassMemberHostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AllClassMemberHostRepository extends JpaRepository<AllClassMemberHostEntity, String> {
    List<AllClassMemberHostEntity> findByHostId(String member_id);
}
