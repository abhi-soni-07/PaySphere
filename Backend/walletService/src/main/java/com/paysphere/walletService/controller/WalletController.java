package com.paysphere.walletService.controller;

import com.paysphere.walletService.dto.*;
import com.paysphere.walletService.dto.response.ApiResponse;
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

    //activate user wallet account
    @PostMapping
    public ResponseEntity<ApiResponse> createWalletAccount(@RequestBody CreateWalletRequest request){
        ApiResponse response = service.createWallet(request.getUserId());
        if (response.getHttpStatusCode() == 409) return ResponseEntity.status(HttpStatus.CONFLICT).body(response);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    //fetch user wallet balance
    @GetMapping("/{userId}/balance")
    public ResponseEntity<ApiResponse> getBalance(@PathVariable long userId){
        ApiResponse response=service.getBalance(userId);
        if(response.getHttpStatusCode() == 404) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    //add balance to user wallet
    @PostMapping("/{userId}/credit")
    public ResponseEntity<ApiResponse> addBalance(@PathVariable long userId,@RequestBody UpdateBalanceRequest request){
        ApiResponse response = service.addBalance(userId, request.getAmount());
        if(response.getHttpStatusCode() == 404) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }


    //deduct amount from user wallet
    @PostMapping("/{userId}/debit")
    public ResponseEntity<ApiResponse> deductBalance(@PathVariable long userId,@RequestBody UpdateBalanceRequest request){
        ApiResponse response = service.deductBalance(userId, request.getAmount());
        if(response.getHttpStatusCode() == 404) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        if (response.getHttpStatusCode() == 409) return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }




}
