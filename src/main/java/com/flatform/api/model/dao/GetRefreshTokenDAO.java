package com.flatform.api.model.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GetRefreshTokenDAO {
    public String getRefTkn(String memberId);
}
