package com.home.JWTuserlogin.model.entity.DTO;

import com.home.JWTuserlogin.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class LoginResponseDTO {
    private User user;
    private String JwtToken;
}
