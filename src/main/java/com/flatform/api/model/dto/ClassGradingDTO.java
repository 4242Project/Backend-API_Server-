package com.flatform.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@Getter
@Setter
public class ClassGradingDTO {
    private String class_id;
    private Double sai_change;

}
