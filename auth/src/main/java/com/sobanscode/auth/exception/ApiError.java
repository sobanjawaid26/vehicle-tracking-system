package com.sobanscode.auth.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ApiError {

    COMPANY_NAME_NOT_MATCH(HttpStatus.FORBIDDEN, "You can not register to another company"),
    REGISTER_NOT_ALLOWED(HttpStatus.FORBIDDEN, "Only admin can register new user"),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "Your username or password is wrong"),
    UNEXPECTED_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred");

    private HttpStatus httpStatus;
    private String message;
}
