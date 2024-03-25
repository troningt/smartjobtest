package com.worshipplanner.mssecurity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class AuthenticationResponse {
    private Long userId;
    private String jwt;
}
