package com.flatform.api.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class ClassListDTO {
    private String class_id;
    private String category_id;
    private String class_name;
    private String nickname;
    private int sai__change_;
    private int fee;
    private Date start_date;
    private String introduce_img_root;
}