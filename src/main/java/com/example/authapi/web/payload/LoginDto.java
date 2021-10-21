package com.example.authapi.web.payload;

import lombok.Data;

@Data
public class LoginDto {
    private String username;
    private String password;
}
