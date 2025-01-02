package com.example.springtask.controller;

import com.example.springtask.ViewsDto.TaskDto;
import com.example.springtask.ViewsDto.UserDto;
import com.example.springtask.models.Task;
import com.example.springtask.repository.TaskRepository;
import com.example.springtask.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskRepository taskRepository;
    private final TaskService taskService;

    @GetMapping("/{id}")
    public TaskDto findById(@PathVariable int id) {
        return taskService.convertToTaskDto(
                taskRepository.findById(id)
                        .orElseThrow(()-> new NullPointerException(
                                String.format("Task for %s id not found", id))));
    }
}
