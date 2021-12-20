package com.flatform.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter

//class 개설 및 수정시 사용하는 DTO
public class AddClassDTO {
    private String class_id = "C0000";
    private String host_id;
    private String univ_id;
    private String introduce_img_root;
    private String category_id;
    private String class_name;
    private int fee;
    private String class_place;
    private String class_location;
    private String material;
    private int limit_number;
    private Date start_date;
    private Date end_date;
    private int class_day;
    private Time class_s_time;
    private Time class_e_time;
    private String class_detail;
    private String class_question;
    private String question_call;
    private String class_change_cancle;
}
