package com.paysphere.walletService.service;

import com.paysphere.walletService.dto.*;
import com.paysphere.walletService.dto.response.*;
import com.paysphere.walletService.entity.WalletEntity;
import com.paysphere.walletService.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {
   @Autowired
   private WalletRepository repository;


    public ApiResponse createWallet(long userId){
        //check if user wallet account already created or not
        WalletEntity instance = repository.findByUserId(userId);
        if(instance != null ) return new WalletAlreadyExistResponse(409,"Wallet already created");
        instance = new WalletEntity();
        instance.setUserId(userId);
        instance = repository.save(instance);
        WalletCreatedResponse response = new WalletCreatedResponse();
        response.setHttpStatusCode(201);
        response.setWalletId(instance.getWalletId());
        return response;
    }

    public ApiResponse getBalance(long userId){
        WalletEntity instance = repository.findByUserId(userId);
        if(instance == null) return new WalletNotExistResponse(404,"Wallet not found");
        BalanceResponse response = new BalanceResponse();
        response.setHttpStatusCode(200);
        response.setBalance(instance.getBalance());
        return response;
    }

    public ApiResponse addBalance(long userId,double amount){
        WalletEntity instance = repository.findByUserId(userId);
        if(instance == null) return new WalletNotExistResponse(404,"Wallet not found");
        instance.setBalance(instance.getBalance() + amount);
        BalanceResponse response = new BalanceResponse();
        response.setHttpStatusCode(200);
        response.setBalance(instance.getBalance());
        repository.save(instance);
        return response;

    }
    public ApiResponse deductBalance(long userId,double amount){
        WalletEntity instance = repository.findByUserId(userId);
        if(instance == null) return new WalletNotExistResponse(404,"Wallet not found");
        if(amount > instance.getBalance()) return new InsufficientBalanceResponse(409,amount,instance.getBalance(),"Insufficient balance");
        BalanceResponse response = new BalanceResponse();
        instance.setBalance(instance.getBalance() - amount);
        response.setHttpStatusCode(200);
        response.setBalance(instance.getBalance());
        repository.save(instance);
        return response;
    }


}
