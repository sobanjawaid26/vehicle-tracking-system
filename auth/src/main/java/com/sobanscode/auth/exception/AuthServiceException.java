package com.sobanscode.auth.exception;

import lombok.Getter;

@Getter
public class AuthServiceException extends RuntimeException{

    private ApiError apiError;

    public AuthServiceException(ApiError apiError) {
        this.apiError = apiError;
    }
}
