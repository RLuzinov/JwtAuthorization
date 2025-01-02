package com.example.springtask.controller;

import com.example.springtask.ViewsDto.TaskRequsestDto;
import com.example.springtask.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final TaskService taskService;

    @PostMapping("/create_task")
    public ResponseEntity<HttpStatus> createTask(@RequestBody TaskRequsestDto taskRequsestDto, Principal principal){
        taskService.save(taskRequsestDto, principal);
        return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
    }
}
