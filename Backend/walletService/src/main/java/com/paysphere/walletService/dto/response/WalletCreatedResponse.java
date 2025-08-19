package com.paysphere.walletService.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class WalletCreatedResponse implements ApiResponse {
    private int httpStatusCode;
    private long walletId;

    @JsonIgnore
    @Override
    public int getHttpStatusCode() {
        return this.httpStatusCode;
    }

    @Override
    public void setHttpStatusCode(int code) {
        this.httpStatusCode = code;
    }

    public long getWalletId() {
        return walletId;
    }

    public void setWalletId(long walletId) {
        this.walletId = walletId;
    }
}
