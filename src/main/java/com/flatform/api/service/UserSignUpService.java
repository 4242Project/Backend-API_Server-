package com.flatform.api.service;

import com.flatform.api.model.dto.UserSignUpDTO;
import java.util.Map;

public interface UserSignUpService
{
    Map<String, String> createUser(UserSignUpDTO userSignUpDTO);
}
