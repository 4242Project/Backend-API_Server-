package com.flatform.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserLoginDTO {
    private String id;
    private String pw;

    public String getMemberPW()
    {
        return pw;
    }

    public String getMemberId()
    {
        return id;
    }
}
