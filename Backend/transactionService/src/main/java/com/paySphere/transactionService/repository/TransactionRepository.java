package com.paySphere.transactionService.repository;

import com.paySphere.transactionService.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
