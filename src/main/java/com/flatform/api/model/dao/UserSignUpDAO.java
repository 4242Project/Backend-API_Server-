package com.flatform.api.model.dao;

import com.flatform.api.model.dto.UserSignUpDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserSignUpDAO {
    public void userSignUp(UserSignUpDTO userSignUpDTO);

}
