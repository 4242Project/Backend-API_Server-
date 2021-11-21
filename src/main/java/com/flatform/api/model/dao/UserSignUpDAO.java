package com.flatform.api.model.dao;

import com.flatform.api.model.dto.UserSignUpDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserSignUpDAO {

    public String searchId(String id);
}
