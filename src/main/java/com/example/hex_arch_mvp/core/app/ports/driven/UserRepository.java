package com.example.hex_arch_mvp.core.app.ports.driven;

import com.example.hex_arch_mvp.core.domain.Entities.User;

import java.util.List;

public interface UserRepository {
    public User saveUser(String name, String email);
    public User getUserById(int id);
    public void removeUserById(int id);
    public List<User> getAllUsers();
}
