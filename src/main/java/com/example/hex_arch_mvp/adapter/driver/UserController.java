package com.example.hex_arch_mvp.adapter.driver;

import com.example.hex_arch_mvp.adapter.driven.InMemoryUserRepository;
import com.example.hex_arch_mvp.core.app.services.UserService;
import com.example.hex_arch_mvp.core.domain.Entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    UserController() {
        /*
        * EmailVO
        * User
        *
        * interface core.app.ports.driven.UserRepository
        * adapter.driven.InMemoryUserRepository implements core.app.ports.driven.UserRepository
        *
        * Quão granular ficam minhas portas e services?
        * interface core.app.ports.driver.SavingUsers
        * core.app.services.UserService implements SavingUsers
        * */
        InMemoryUserRepository inMemoryUserRepository = new InMemoryUserRepository();
        this.userService = new UserService(inMemoryUserRepository);
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") String id) {
        User user = this.userService.getUserById(Integer.parseInt(id));
        return ResponseEntity.ok(user.getEmail());
    }

    @PostMapping("/new")
    public ResponseEntity<?> newUser(@RequestBody UserForm user) {
        User newUser = this.userService.saveUser(user.getUsername(), user.getEmail());
        return ResponseEntity.ok(newUser.getEmail());
    }
}
