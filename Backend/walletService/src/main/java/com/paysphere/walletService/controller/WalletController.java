package com.paysphere.walletService.controller;

import com.paysphere.walletService.dto.*;
import com.paysphere.walletService.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/wallets")
public class WalletController {
    @Autowired
    private WalletService service;

    @PostMapping
    public ResponseEntity<WalletResponse> createWalletAccount(@RequestBody CreateWalletRequest request){
        WalletResponse response = service.createWallet(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }
    @GetMapping("/{userId}/balance")
    public ResponseEntity<BalanceResponse> getBalance(@PathVariable long userId){
        BalanceResponse response=service.getBalance(userId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/{userId}/credit")
    public ResponseEntity<UpdateBalanceResponse> addBalance(@PathVariable long userId,@RequestBody UpdateBalanceRequest request){
        UpdateBalanceResponse response =new UpdateBalanceResponse();
        if(response.getStatus() == "failed") return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @PostMapping("/{userId}/debit")
    public ResponseEntity<UpdateBalanceResponse> deductBalance(@PathVariable long userId,@RequestBody UpdateBalanceRequest request){
        UpdateBalanceResponse response =new UpdateBalanceResponse();
        if(response.getStatus() == "failed") return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }




}
