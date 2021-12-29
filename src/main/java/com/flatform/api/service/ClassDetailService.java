package com.flatform.api.service;

import com.flatform.api.model.dto.ClassDetailDTO;

import java.util.List;

public interface ClassDetailService {
    List<ClassDetailDTO> getClassDetailService(String classId);
}
