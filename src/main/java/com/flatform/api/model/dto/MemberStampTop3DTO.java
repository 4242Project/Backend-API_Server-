package com.flatform.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class MemberStampTop3DTO {
    private String stamp_top_1;
    private String stamp_top_2;
    private String stamp_top_3;
}
