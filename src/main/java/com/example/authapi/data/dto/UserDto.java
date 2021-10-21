package com.example.authapi.data.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class UserDto {
    @NonNull()
    private String username;
    @NonNull()
    private String email;
    @NonNull()
    private String password;
}
