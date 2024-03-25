package com.worshipplanner.mssecurity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AuthenticationRequest {
    @NotBlank(message = "You must write an username")
    private String username;

    @NotNull
    @NotBlank
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;
}
