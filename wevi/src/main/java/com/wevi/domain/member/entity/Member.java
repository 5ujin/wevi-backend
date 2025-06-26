package com.wevi.domain.member.entity;

import com.wevi.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "mb_mbr_base")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mbr_no")
    private Long id;

    @Column(name = "login_id", nullable = false, length = 100)
    private String loginId;

    @Column(name = "mbr_nm", length = 100)
    private String name;

    @Column(name = "password", nullable = false, length = 150)
    private String password;

    @Column(name = "passwd_fail_cnt", columnDefinition = "integer default 0")
    private Integer passwordFailCount = 0;

    @Column(name = "gen", length = 1)
    private String gender;

    @Column(name = "cell_no", length = 100)
    private String cellPhone;

    @Column(name = "bday")
    private LocalDate birthDay;

    @Column(name = "role", length = 10)
    private String role;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "email_valid_yn", length = 1)
    private String emailValidYn = "N";

    @Column(name = "enabled_yn", length = 1)
    private String enabledYn = "Y";

    @Column(name = "last_login_dtime")
    private LocalDateTime lastLoginDateTime;

    @Column(name = "passwd_chg_dtime")
    private LocalDateTime passwordChangedDateTime;

    @Column(name = "withdrawal_at")
    private LocalDateTime withdrawalAt;

    @Column(name = "creator", length = 100)
    private String creator;


    @Column(name = "updater", length = 100)
    private String updater;
}
