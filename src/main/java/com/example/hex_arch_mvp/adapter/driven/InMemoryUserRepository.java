package com.example.hex_arch_mvp.adapter.driven;

import com.example.hex_arch_mvp.core.app.ports.driven.UserRepository;
import com.example.hex_arch_mvp.core.domain.Entities.User;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class InMemoryUserRepository implements UserRepository {
    private final List<User> users = new ArrayList<>();

    public InMemoryUserRepository() {
        this.saveUser("User B", "user_a@test.com");
        this.saveUser("User B", "user_b@test.com");

    }

    @Override
    public User saveUser(String username, String email) {
        Optional<User> maxUser = users.stream().max(Comparator.comparing(User::getId));
        int newUserId = 0;
        if (maxUser.isPresent()) {
            newUserId = maxUser.get().getId() +1;
        }
        User newUser = new User(newUserId, username, email);
        this.users.add(newUser);
        return newUser;
    }

    @Override
    public User getUserById(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void removeUserById(int id) {

    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }
}
