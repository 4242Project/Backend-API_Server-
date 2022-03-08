package com.flatform.api.service;

import com.flatform.api.model.dto.UserClassDTO;
import java.util.List;

public interface UserClassService
{
    List<UserClassDTO> getUserTodayClass(String userId, int date);
}
