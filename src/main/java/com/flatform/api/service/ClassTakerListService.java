package com.flatform.api.service;

import com.flatform.api.model.dto.ClassTakerListDTO;

import java.util.List;

public interface ClassTakerListService
{
    List<ClassTakerListDTO> getClasstakerList(String class_id);
    //public stampTop3DTO getClasstakerstamp(String member_id);
}
