package com.example.springtask.controller;


import com.example.springtask.services.UserService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/example")
@RequiredArgsConstructor
public class ExampleController {
    private final UserService userService;

    @GetMapping
    public String example(){
        return "Hello World";
    }

    @GetMapping("/admin")
    public String exampleAdmin(){
        return "Hello Admin";
    }

    @GetMapping("/user")
    public String exampleUser(Principal principal){
        return principal.getName();
    }
}
