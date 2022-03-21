package com.flatform.api.model.dto;

import lombok.*;

import javax.persistence.Entity;

@AllArgsConstructor
@Getter
@Setter

public class MemberStampNumDTO {
    private String category_id;
    private int stamp_count;
}
