package com.flatform.api.repository.dto;

import lombok.*;

import javax.persistence.Column;
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
