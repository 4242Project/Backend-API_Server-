package com.flatform.api.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@AllArgsConstructor
@Getter
@Setter
public class UserClassDTO {
    private String class_id;
    private String category_name;
    private String class_name;
    private Time class_s_time;
    private Time class_e_time;
}
