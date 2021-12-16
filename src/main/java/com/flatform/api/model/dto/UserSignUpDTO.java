package com.flatform.api.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserSignUpDTO {
    private String id;
    private String pw;
    @JsonProperty("univid")
    private String univ_id;
    private String name;
    private String email;
    private String nickname;
    private int age;
    private String phone;
    private String department;
    public String refreshtoken;
    public String getUserId()
    {
        return id;
    }
    public void setRefreshToken(String refTkn)
    {
        this.refreshtoken = refTkn;
    }

    // refresh token default값 설정
    public UserSignUpDTO()
    {
        this.refreshtoken = "REF_TKN_NULL";
    }



}
