package com.flatform.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RefreshTokenDTO
{
    private String refreshTokenValue;
    private String userID;
}
