package com.flatform.api.repository.dto;

import java.sql.Time;
import java.util.Date;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ClassDetailDTO {
    private String class_id;
    private String category_id;
    private String class_name;
    private int fee;
    private String nickname;
    private String department;
    private int sai_change;
    private String class_place;
    private String material;
    private String introduce_img_root;
    private int limit_number;
    private Time class_s_time;
    private Date start_date;
    private String class_detail;
    private String class_location;
    private String class_question;
    private String class_change_cancle;
    private int listener_num;
}
