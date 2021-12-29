package com.flatform.api.model.dao;

import com.flatform.api.model.dto.AdDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdDAO {
    List<AdDTO> getAdInfo();
}
