package com.worshipplanner.mssecurity.controller;

import com.worshipplanner.mssecurity.dto.UserDTO;
import com.worshipplanner.mssecurity.exception.CustomException;
import com.worshipplanner.mssecurity.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    @PreAuthorize("hasAuthority('READ_ALL_USERS')")
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }


    @PostMapping
    @PreAuthorize("hasAuthority('SAVE_USER')")
    public ResponseEntity<UserDTO> createOne(@RequestBody @Valid UserDTO user) throws CustomException {
        return ResponseEntity.ok(userService.createOne(user));
    }
}
