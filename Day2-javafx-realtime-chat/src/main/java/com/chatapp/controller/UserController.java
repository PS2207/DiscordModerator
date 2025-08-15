package com.chatapp.controller;

import com.chatapp.entity.User;
import com.chatapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        if (userService.loginUser(user.getUsername(), user.getPassword()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already exists");
        }
        return ResponseEntity.ok(userService.registerUser(user));
    }

    
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        Optional<User> loggedInUser = userService.loginUser(user.getUsername(), user.getPassword());
        if (loggedInUser.isPresent()) {
            User safeUser = loggedInUser.get();
            safeUser.setPassword(null); // Hide password
            return safeUser;
        }
        return null;
    }


}
//POST - http://localhost:8082/api/user/register
//POST - http://localhost:8082/api/user/login
