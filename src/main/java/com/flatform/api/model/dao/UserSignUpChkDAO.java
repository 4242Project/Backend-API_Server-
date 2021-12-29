package com.flatform.api.model.dao;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserSignUpChkDAO
{
    boolean searchId(String id);
}
