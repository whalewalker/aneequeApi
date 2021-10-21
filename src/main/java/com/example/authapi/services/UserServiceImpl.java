package com.example.authapi.services;

import com.example.authapi.data.dto.AuthDetails;
import com.example.authapi.data.dto.UserDto;
import com.example.authapi.data.model.User;
import com.example.authapi.data.repository.UserRepository;
import com.example.authapi.web.payload.LoginDto;
import com.example.authapi.web.payload.RegisterDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RegisterDto register(RegisterDto registerDto) {
        return null;
    }

    @Override
    public AuthDetails login(LoginDto loginDto) {
        return null;
    }

    @Override
    public List<UserDto> getAllUser() {
        return null;
    }
}
