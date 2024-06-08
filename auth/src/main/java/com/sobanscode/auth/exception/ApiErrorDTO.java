package com.sobanscode.auth.exception;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiErrorDTO {

    private int code;
    private String message;
}
