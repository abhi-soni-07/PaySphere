package com.paySphere.transactionService.controller;

import com.paySphere.transactionService.dto.TransactionRequest;
import com.paySphere.transactionService.repository.TransactionRepository;
import com.paySphere.transactionService.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import  com.paySphere.transactionService.model.Transaction;


@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    TransactionService service;

    @Autowired
    TransactionRepository transaction;
    // payment initiated
    @PostMapping("/initiate")
    public String initiate(@RequestBody TransactionRequest request) {
        return "SUCCESS";
    }

    // get the status of a transaction
    @GetMapping("/status/{transaction_id}")
    public String status(@PathVariable int transaction_id) {
        return "SUCCESS";
    }


    // get transaction details
    @GetMapping("/{transaction_id}")
    public ResponseEntity<Transaction> getTransactionDetails(@PathVariable long transactionId) {
        Transaction response = service.getTransactionDetailsById(transactionId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // get user transaction history
    @GetMapping("/user/{user_id}")
    public String getUserTransactionHistory(@PathVariable int user_id) {
        return "SUCCESS";
    }

    // retry a failed transaction
    @PostMapping("/retry/{transaction_id}")
    public String retryTransaction(@PathVariable int transaction_id) {
        return "RETRY INITIATED";
    }

    // reverse a completed transaction (refund)
    @PostMapping("/reverse/{transaction_id}")
    public String reverseTransaction(@PathVariable int transaction_id) {
        return "TRANSACTION REVERSED";
    }

    // cancel a pending transaction
    @PostMapping("/cancel/{transaction_id}")
    public String cancelTransaction(@PathVariable int transaction_id) {
        return "TRANSACTION CANCELED";
    }

    // get transaction summary for a user
    @GetMapping("/summary/{user_id}")
    public String getTransactionSummary(@PathVariable int user_id) {
        return "USER SUMMARY";
    }

    @GetMapping("/statement/pdf/{user_id}")
    public String downloadTransactionStatement(@PathVariable int user_id) {
        return "PDF GENERATED FOR USER ID: " + user_id;
    }

}
