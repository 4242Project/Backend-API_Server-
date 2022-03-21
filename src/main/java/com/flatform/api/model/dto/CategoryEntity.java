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
public class CategoryEntity {
    @Id
    @Column(name = "category_id")
    private String categoryId;
}
