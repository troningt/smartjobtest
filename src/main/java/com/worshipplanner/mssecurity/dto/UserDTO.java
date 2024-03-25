package com.worshipplanner.mssecurity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.worshipplanner.mssecurity.util.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDTO {
    @JsonProperty("id")
    private Long userId;

    private String username;
    private String name;
    private String email;
    private Role role;
    private String createdAt;
    private String updatedAt;
    private String lastLogin;
    private String jwt;
    private List<PhoneDTO> phones;
}
