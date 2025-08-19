package com.paysphere.walletService.service;

import com.paysphere.walletService.dto.*;
import com.paysphere.walletService.entity.WalletEntity;
import com.paysphere.walletService.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {
   @Autowired
   private WalletRepository repository;
    public WalletResponse createWallet(CreateWalletRequest request){
        WalletEntity instance = new WalletEntity();
        instance.setUserId(request.getUserId());
        instance = repository.save(instance);
        WalletResponse response = new WalletResponse();
        response.setBalance(instance.getBalance());
        response.setId(instance.getWalletId());
        response.setUserId(instance.getUserId());
        return response;
    }

    public BalanceResponse getBalance(long userid){
        WalletEntity instance = new WalletEntity();
        instance = repository.findByUserId(userid);
        if (instance == null) return null;
        BalanceResponse response = new BalanceResponse();
        response.setUserId(userid);
        response.setBalance(instance.getBalance());
        return response;
    }

    public UpdateBalanceResponse addBalance(long userId,double amount){
        WalletEntity instance = repository.findByUserId(userId);
        if(instance == null) return UpdateBalanceResponse(0,0,0,)
    }


}
