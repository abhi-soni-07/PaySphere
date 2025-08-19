package com.paysphere.walletService.dto.response;

public interface ErrorResponse extends ApiResponse {
    void setErrorMessage(String message);
}
