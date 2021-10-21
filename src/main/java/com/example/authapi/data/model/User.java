package com.example.authapi.data.model;

import com.example.authapi.data.repository.Storable;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class User implements Storable {
    private String id;
    private String username;
    private String email;
    private String password;
    private Set<Role> roles = new HashSet<>();

    @Override
    public String getAccountNumber() {
        return null;
    }

    @Override
    public String getName() {
        return username;
    }
}
