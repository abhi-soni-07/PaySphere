package com.paySphere.transactionService.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,unique = true)
    private Long id;
    @Column(name = "from_user_id",nullable = false)
    private Integer fromUser;
    @Column(name = "to_user_id",nullable = false)
    private Integer toUser;
    @Column(nullable = false)
    private BigDecimal amount;
    @Column(nullable = false)
    private String transaction_type;
    @Column(nullable = false)
    private String status;
    @Column(name = "reference_id",nullable = false)
    private String transactionId;
    @CreationTimestamp
    private LocalDateTime initiated_at;
    @UpdateTimestamp
    private LocalDateTime completed_at;
}
