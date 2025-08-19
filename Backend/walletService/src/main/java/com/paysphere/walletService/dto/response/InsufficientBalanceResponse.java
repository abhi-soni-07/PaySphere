package com.paysphere.walletService.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class InsufficientBalanceResponse implements ErrorResponse{
    private int httpStatusCode;
    private double amountToDeduct;
    private  double balance;
    private String errorMessage;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public double getAmountToDeduct() {
        return amountToDeduct;
    }

    public void setAmountToDeduct(double amountToDeduct) {
        this.amountToDeduct = amountToDeduct;
    }



    public InsufficientBalanceResponse() {
    }
    public InsufficientBalanceResponse(int code,double amount,double balance,String message){
        this.httpStatusCode = code;
        this.amountToDeduct = amount;
        this.balance = balance;
        this.errorMessage = message;
    }


    @Override
    public void setErrorMessage(String message) {
        this.errorMessage = message;
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


}
