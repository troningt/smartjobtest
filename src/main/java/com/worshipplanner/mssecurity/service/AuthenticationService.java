package com.worshipplanner.mssecurity.service;

import com.worshipplanner.mssecurity.dto.AuthenticationRequest;
import com.worshipplanner.mssecurity.dto.AuthenticationResponse;
import com.worshipplanner.mssecurity.dto.UserDTO;
import com.worshipplanner.mssecurity.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.worshipplanner.mssecurity.config.Constants.TIME_FORMAT;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtService jwtService;
    public AuthenticationResponse login(AuthenticationRequest request) throws CustomException {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                request.getUsername(), request.getPassword()
        );

        authenticationManager.authenticate(authenticationToken);

        UserDTO userDTO = userService.findByUsername(request.getUsername());
        DateFormat formatter = new SimpleDateFormat(TIME_FORMAT);
        Date date = new Date();
        userDTO.setLastLogin(formatter.format(date));
        String jwt = jwtService.generateToken(userDTO, generateExtraClaims(userDTO));
        userDTO.setJwt(jwt);
        //update User
        userDTO.setCreatedAt(formatter.format(date));
        userService.updateOne(userDTO);

        return AuthenticationResponse.builder().jwt(jwt).build();
    }

    private Map<String, Object> generateExtraClaims(UserDTO userDTO) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("name", userDTO.getName());
        extraClaims.put("role", userDTO.getRole().name());
        return extraClaims;
    }
}
