package com.flatform.api.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Builder
@Entity(name = "class")
public class AllClassMemberHostEntity {
    @Id
    private String class_id;

    @Column(length = 30)
    private String class_name;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date start_date;

    @Column(length = 30, name = "host_id")
    private String hostId;
}
