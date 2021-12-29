package com.flatform.api.service;

import com.flatform.api.model.dto.UserSignUpChkDTO;

import java.util.List;

public interface UserSignUpChkService {
    List<Object> checkId(String targetId);
}
