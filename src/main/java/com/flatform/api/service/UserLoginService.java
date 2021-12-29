package com.flatform.api.service;

import com.flatform.api.model.dto.UserLoginDTO;

import java.util.Map;

public interface UserLoginService {
    Map<String, Object> verifyUser(UserLoginDTO userLoginDTO);
}
