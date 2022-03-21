package com.flatform.api.model.dto;

import lombok.*;

import javax.persistence.*;


@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "advertisement")                     // 테이블 명
public class AdEntity {

    @Id
    private String ad_id;

    @Column(length = 600)
    private String image;

    @Column(length = 600)
    private String hyperlink;
}
