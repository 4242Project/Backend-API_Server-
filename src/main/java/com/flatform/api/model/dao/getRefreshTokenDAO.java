package com.flatform.api.model.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface getRefreshTokenDAO {
    public String getRefTkn(String memberId);
}
