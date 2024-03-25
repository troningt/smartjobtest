package com.worshipplanner.mssecurity.service;

import com.worshipplanner.mssecurity.dto.UserDTO;
import com.worshipplanner.mssecurity.entity.User;
import com.worshipplanner.mssecurity.exception.CustomException;
import com.worshipplanner.mssecurity.exception.NotFoundException;
import com.worshipplanner.mssecurity.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.worshipplanner.mssecurity.config.Constants.TIME_FORMAT;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    public UserDTO createOne(UserDTO user) throws CustomException {
        if (userRepository.findByEmail(user.getEmail()).isPresent())
            throw new CustomException("Email is already registered");

        if (userRepository.findByUsername(user.getUsername()).isPresent())
            throw new CustomException("Username is already registered");

        DateFormat formatter = new SimpleDateFormat(TIME_FORMAT);
        user.setCreatedAt(formatter.format(new Date()));
        User userEntity = modelMapper.map(user, User.class);
        User userResult = userRepository.save(userEntity);
        return modelMapper.map(userResult, UserDTO.class);
    }

    public UserDTO findByUsername(String username) {
        User userFound = userRepository.findByUsername(username).orElseThrow(() -> new NotFoundException(username));
        return modelMapper.map(userFound, UserDTO.class);
    }

    @Transactional
    public void updateOne(UserDTO userDTO) throws CustomException {
        User user = userRepository.findByUsername(userDTO.getUsername()).orElseThrow(() -> new UsernameNotFoundException(userDTO.getUsername()));
        user.setToken(userDTO.getJwt());
        try {
            user.setLastLogin(new SimpleDateFormat(TIME_FORMAT).parse(userDTO.getCreatedAt()));
            user.setCreatedAt(new SimpleDateFormat(TIME_FORMAT).parse(userDTO.getCreatedAt()));
            user.setUpdatedAt(new SimpleDateFormat(TIME_FORMAT).parse(userDTO.getUpdatedAt()));
        } catch (Exception ex) {
            throw new CustomException(ex.getMessage());
        }
        userRepository.save(user);
    }
}
