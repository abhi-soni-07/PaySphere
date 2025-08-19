package com.paysphere.walletService.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class WalletNotExistResponse implements ErrorResponse{
    private int httpStatusCode;
    private String errorMessage;

    public WalletNotExistResponse() {

    }
    public WalletNotExistResponse(int code,String message){

        this.httpStatusCode = code;
        this.errorMessage = message;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public void setErrorMessage(String message) {
        this.errorMessage = message;
    }


    @Override
    public int getHttpStatusCode() {
        return this.httpStatusCode;
    }

    @Override
    public void setHttpStatusCode(int code) {
        this.httpStatusCode = code;

    }
}
