package com.flatform.api.model.dao;

import com.flatform.api.model.dto.UserSignUpChkDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserSignUpChkDAO {

    public List<UserSignUpChkDTO> searchId(String id);
}
