package com.flatform.api.service;

import com.flatform.api.model.dto.UserLoginDTO;

import java.util.Map;

public interface UserLoginService {
    public Map verifyUser(UserLoginDTO userLoginDTO);
}
