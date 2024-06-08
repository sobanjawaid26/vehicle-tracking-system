package com.sobanscode.auth.dto.request;

import com.sobanscode.auth.data.enums.Roles;
import lombok.*;

import javax.validation.constraints.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequestDto {
    @NotBlank
    @NotNull
    @Size(min = 3, max = 20 ,message = "The username can be a minimum of 3 characters and a maximum of 20 characters.")
    private String username;
    @NotBlank
    @NotNull
    @Size(min = 3, max = 32 ,message = "The password name can be a minimum of 4 characters and a maximum of 32 characters.")
    private String password;
    private String name;
    private String surname;
    private String companyName;
    private Roles role;
}
