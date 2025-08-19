package com.paysphere.walletService.repository;

import com.paysphere.walletService.entity.WalletEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WalletRepository extends JpaRepository<WalletEntity,Long> {

    @Query(value = "select * from paysphere.wallets where user_id = :userId",nativeQuery = true)
    WalletEntity findByUserId(@Param("userId") long userId);

    @Modifying
    @Transactional
    @Query(value = "update paysphere.wallets set balance = :balace where user_id = :userId",nativeQuery = true)
    int updateBalanceByUserId(@Param("userId") long userId,@Param("balance") double balance);
}
