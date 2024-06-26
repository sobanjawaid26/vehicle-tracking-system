package com.sobanscode.vehicle.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ApiError {
    USER_NOT_COMPANY_ADMIN(HttpStatus.FORBIDDEN, "User not company admin"),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User not found"),
    GROUP_NOT_FOUND(HttpStatus.NOT_FOUND, "Group not found"),
    USER_ALREADY_AUTHORIZED_TO_VEHICLE(HttpStatus.CONFLICT, "User already authorized to vehicle"),
    VEHICLE_NOT_FOUND(HttpStatus.NOT_FOUND, "Vehicle not found"),
    USER_NOT_AUTHORIZED_TO_GROUP(HttpStatus.FORBIDDEN, "User not authorized for parent group"),
    UNEXPECTED_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred");

    HttpStatus httpStatus;
    private String message;

}
