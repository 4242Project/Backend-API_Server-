package com.flatform.api.repository.dao;

import org.apache.ibatis.annotations.Mapper;
import java.util.HashMap;

@Mapper
public interface UserLoginDAO {
    String verifyUseridDB(String memberId);
    String verifyUserpwDB(String memberId);
    void saveRefreshToken(HashMap<String, Object> refreshTokenInfo);
}
