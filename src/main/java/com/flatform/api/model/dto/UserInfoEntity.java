package com.flatform.api.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Builder
@Entity(name = "member")
public class UserInfoEntity {
    @Id
    private String id;

    @Column
    private String pw;

    @Column(name = "univ_id")
    @JsonProperty("univid")
    private String univId;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String nickname;

    @Column
    private int age;

    @Column(name = "profile_img_root")
    private String profileImgRoot;

    @Column
    private String phone;

    @Column
    private String department;

    @Column
    private String refreshtoken;




}
