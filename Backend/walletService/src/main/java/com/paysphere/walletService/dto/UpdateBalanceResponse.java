package com.paysphere.walletService.dto;

import java.time.LocalDateTime;

public class UpdateBalanceResponse {
    private long userId;
    private double amount;
    private double balance;
    private String status;
    private String message;
    private LocalDateTime timeStamp;

    public UpdateBalanceResponse() {
    }

    public UpdateBalanceResponse(long userId, double amount, double balance, String status, String message, LocalDateTime timeStamp) {
        this.userId = userId;
        this.amount = amount;
        this.balance = balance;
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
