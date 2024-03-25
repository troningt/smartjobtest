package com.worshipplanner.mssecurity.service;

import com.worshipplanner.mssecurity.dto.UserDTO;
import com.worshipplanner.mssecurity.entity.User;
import com.worshipplanner.mssecurity.exception.CustomException;
import com.worshipplanner.mssecurity.repository.UserRepository;
import com.worshipplanner.mssecurity.util.Role;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private UserService userService;



    @Test
    void findAll() {
        List<User> users = List.of(User.builder().userId(1).email("rtheran@gmail.com").role(Role.ADMINISTRATOR).username("rtheran").build());
        when(userRepository.findAll()).thenReturn(users);
        when(modelMapper.map(any(User.class),any())).thenReturn(UserDTO.builder().userId(1L).email("rtheran@gmail.com").role(Role.ADMINISTRATOR).username("rtheran").build());
        List<UserDTO> userDTOList = userService.findAll();
        assertFalse(userDTOList.isEmpty());
    }

    @Test
    void createOne() throws CustomException {
        when(userRepository.findByEmail(any())).thenReturn(Optional.empty());
        when(userRepository.findByUsername(any())).thenReturn(Optional.empty());
        when(userRepository.save(any(User.class))).thenReturn(User.builder().userId(1).email("rtheranmock@gmail.com").role(Role.ADMINISTRATOR).username("rtheran").build());
        userService.createOne(UserDTO.builder().userId(1L).email("rtheranmock@gmail.com").role(Role.ADMINISTRATOR).username("rtheran").build());
        verify(userRepository.save(any(User.class)));
    }

    @Test
    void findByUsername() {
    }

    @Test
    void updateOne() {
    }
}