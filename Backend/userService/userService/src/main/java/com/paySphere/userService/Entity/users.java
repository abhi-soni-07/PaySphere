package com.paySphere.userService.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class users {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String full_name;

    @Column(unique = true,nullable = false)
    private String email;

    @Column(unique = true,nullable = false)
    private String phone_number;

    @Column(nullable = false)
    private String password;

    @Column
    private String kyc_status;

    @Column
    private LocalDateTime created_at;


}
