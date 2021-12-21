package com.flatform.api.service;

import com.flatform.api.model.dto.ClassTakerListDTO;
import com.flatform.api.model.dto.stampTop3DTO;

import java.util.List;

public interface ClassTakerListService {
    public List<ClassTakerListDTO> getClasstakerList(String class_id);
    //public stampTop3DTO getClasstakerstamp(String member_id);
}
