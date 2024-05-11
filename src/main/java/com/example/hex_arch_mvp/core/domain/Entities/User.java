package com.example.hex_arch_mvp.core.domain.Entities;

import com.example.hex_arch_mvp.core.domain.ValueObjects.EmailVO;

public class User {
    private final int id;
    private final String username;
    private final EmailVO email;

    public User(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = new EmailVO(email);
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return this.email.getEmail();
    }
}
