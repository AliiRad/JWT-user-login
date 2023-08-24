package com.home.JWTuserlogin.model.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class RegistrationUserDTO {
    private String username;
    private String password;
}
