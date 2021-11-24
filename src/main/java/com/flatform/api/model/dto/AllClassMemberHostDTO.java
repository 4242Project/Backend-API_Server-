package com.flatform.api.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class AllClassMemberHostDTO {
    private String class_id;
    private String class_name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date start_date;
}
