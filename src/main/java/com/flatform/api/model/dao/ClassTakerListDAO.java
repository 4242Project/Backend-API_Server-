package com.flatform.api.model.dao;

import com.flatform.api.model.dto.ClassTakerListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassTakerListDAO {
    public List<ClassTakerListDTO> getClassTakerListData(String class_id);
   // public List<MemberStampTop3DTO> getMemberStampTop(String member_id);
}
