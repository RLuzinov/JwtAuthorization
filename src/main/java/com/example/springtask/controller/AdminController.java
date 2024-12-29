package com.example.springtask.controller;

import com.example.springtask.models.Role;
import com.example.springtask.models.User;
import com.example.springtask.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final UserRepository userRepository;

    @GetMapping("/all_users")
    public Optional<User> allUsers() {
        return userRepository.findByRole("ROLE_USER");
    }




}
