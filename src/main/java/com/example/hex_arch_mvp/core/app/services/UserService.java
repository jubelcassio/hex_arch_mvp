package com.example.hex_arch_mvp.core.app.services;

import com.example.hex_arch_mvp.core.app.ports.driven.UserRepository;
import com.example.hex_arch_mvp.core.app.ports.driver.SavingUsers;
import com.example.hex_arch_mvp.core.domain.Entities.User;
import org.springframework.stereotype.Service;

@Service
public class UserService implements SavingUsers {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(String name, String email) {
        return this.userRepository.saveUser(name, email);
    }

    public User getUserById(int id) {
        return this.userRepository.getUserById(id);
    }
}
