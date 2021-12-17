package com.flatform.api.model.dao;

import com.flatform.api.model.dto.UserClassDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface UserLoginDAO {
    public String verifyUseridDB(String memberId);
    public String verifyUserpwDB(String memberId);
    public void saveRefreshToken(HashMap<String, Object> refreshTokenInfo);
}
