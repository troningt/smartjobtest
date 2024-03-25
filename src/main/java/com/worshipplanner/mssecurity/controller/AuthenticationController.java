package com.worshipplanner.mssecurity.controller;

import com.worshipplanner.mssecurity.dto.AuthenticationRequest;
import com.worshipplanner.mssecurity.dto.AuthenticationResponse;
import com.worshipplanner.mssecurity.exception.CustomException;
import com.worshipplanner.mssecurity.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping("/login")
    @PreAuthorize("permitAll")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody @Valid AuthenticationRequest request) throws CustomException {
        return ResponseEntity.ok(authenticationService.login(request));
    }
}
