package com.paysphere.walletService.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class WalletAlreadyExistResponse implements ErrorResponse{
    private int httpStatusCode;
    private String errorMessage;

    public WalletAlreadyExistResponse(int status,String message) {
        this.httpStatusCode = status;
        this.errorMessage = message;
    }


    @JsonIgnore
    @Override
    public int getHttpStatusCode(){
        return this.httpStatusCode;
    }

    @Override
    public void setHttpStatusCode(int code){
         this.httpStatusCode = code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public void setErrorMessage(String message) {
        this.errorMessage = message;
    }
}
