package com.paySphere.transactionService.service;

import com.paySphere.transactionService.model.Transaction;
import com.paySphere.transactionService.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository repository;
    public Transaction getTransactionDetailsById(long id){
        return repository.getById(id);
    }



}
