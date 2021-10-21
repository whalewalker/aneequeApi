package com.example.authapi.services;

import com.example.authapi.data.dto.AuthDetails;
import com.example.authapi.data.dto.UserDto;
import com.example.authapi.web.payload.LoginDto;
import com.example.authapi.web.payload.RegisterDto;

import java.util.List;

public interface UserService {
    RegisterDto register(RegisterDto registerDto);
    AuthDetails login(LoginDto loginDto);
    List<UserDto> getAllUser();
}
