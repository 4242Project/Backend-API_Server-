package com.flatform.api.service;

import com.flatform.api.model.dto.ClassListDTO;

import java.util.List;

public interface ClassListService {
    List<ClassListDTO> getClassListByCat(String univ_id, String cat_name);
    List<ClassListDTO> getClassListByQuery(String univ_id, String query);
}
