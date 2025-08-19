package com.paysphere.walletService.dto;

//credit aur debit
public class UpdateBalanceRequest {
   private double amount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
