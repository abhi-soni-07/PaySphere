package com.paySphere.transactionService.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Transaction {
    @Id
    @Column(nullable = false,unique = true)
    private Long id;
    @Column(name = "from_user_id",nullable = false)
    private Integer from_user;
    @Column(name = "to_user_id",nullable = false)
    private Integer to_user;
    @Column(nullable = false)
    private BigDecimal amount;
    @Column(nullable = false)
    private String transaction_type;
    @Column(nullable = false)
    private String status;
    @Column(name = "reference_id",nullable = false)
    private String transaction_id;
    private LocalDateTime initiated_at;
    private LocalDateTime completed_at;
}
