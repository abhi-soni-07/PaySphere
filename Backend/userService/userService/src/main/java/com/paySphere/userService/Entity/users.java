package com.paySphere.userService.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class users {

    @Id
    @Column
    private long id;

    @Column
    private String full_name;

    @Column
    private String email;

    @Column
    private String phone_number;

    @Column
    private String kyc_status;

    @Column
    private LocalDateTime created_at;


}
