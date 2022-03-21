package com.flatform.api.model.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Builder
@Entity(name = "signup")
public class EnrollClassEntity {

    @Id
    private String class_id;

    @Column(length = 30)
    private String member_id;
}
