package com.sobanscode.group.exception;

import lombok.Getter;

@Getter
public class GroupServiceException extends RuntimeException{
    private ApiError apiError;

    public GroupServiceException(ApiError apiError) {
        this.apiError = apiError;
    }

}