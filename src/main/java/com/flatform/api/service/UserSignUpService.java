package com.flatform.api.service;

import com.flatform.api.model.dto.UserSignUpDTO;

import java.util.Map;

public interface UserSignUpService {
    public Map createUser(UserSignUpDTO userSignUpDTO);
}
