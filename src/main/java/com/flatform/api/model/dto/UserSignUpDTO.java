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
    private String refreshtoken;




}
