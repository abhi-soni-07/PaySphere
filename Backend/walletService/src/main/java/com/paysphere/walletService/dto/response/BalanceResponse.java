package com.paysphere.walletService.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BalanceResponse implements ApiResponse {
    private int httpStatusCode;
    private double balance;

    public BalanceResponse() {
        super();
    }

    @JsonIgnore
    @Override
    public int getHttpStatusCode() {
        return this.httpStatusCode;
    }

    @Override
    public void setHttpStatusCode(int code) {
        this.httpStatusCode = code;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
