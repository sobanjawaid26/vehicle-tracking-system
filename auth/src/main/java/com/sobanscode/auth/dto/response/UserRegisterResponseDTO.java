package com.sobanscode.auth.dto.response;

import com.sobanscode.auth.data.enums.Roles;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterResponseDTO {
    private String username;
    private Long userId;
    private String name;
    private String surname;
    private Long companyId;
    private String companyName;
    private Roles roles;
}
