package com.example.hex_arch_mvp.core.domain.ValueObjects;

public class EmailVO {
    private final String email;

    public EmailVO(String email) {
        this.validateEmail(email);
        this.email = email;
    }

    public void validateEmail(String email) {
        boolean isValid = false;
        if (email != null && !email.isEmpty() && email.contains("@")) {
            isValid = true;
        }
        if(!isValid){
            throw new IllegalArgumentException("Invalid email");
        }
    }
    public String getEmail() {
        return email;
    }
}
