package com.flatform.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AllClassMemberTakeDTO {
    private String class_id;
    private String class_brief;
    private String start_date;
    private boolean sai_chk;
}
