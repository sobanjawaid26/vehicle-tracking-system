package com.sobanscode.vehicle.dto.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sobanscode.vehicle.data.enums.Roles;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GeneralRequestHeaderDTO {
    private Long userId;
    private String name;
    private String surname;
    private Long companyId;
    private String companyName;
    private Roles role;

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            System.out.println("********************************************************************************GeneralRequestHeaderDto.toString() is called");
            System.out.println("UserID : " + this.userId);
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}