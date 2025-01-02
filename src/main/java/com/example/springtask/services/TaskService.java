package com.example.springtask.services;

import com.example.springtask.ViewsDto.TaskDto;
import com.example.springtask.ViewsDto.TaskRequsestDto;
import com.example.springtask.models.Status;
import com.example.springtask.models.Task;
import com.example.springtask.repository.TaskRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final ModelMapper modelMapper;
    private final TaskRepository taskRepository;
    private final UserService userService;

    @Transactional
    public void save(TaskRequsestDto taskRequsestDto, Principal principal) {
        Task task = new Task();
        task.setNameTask(taskRequsestDto.getNameTask());
        task.setDescription(taskRequsestDto.getDescription());
        task.setUser(userService.getByUsername(principal.getName()));
        task.setStatus(Status.NOT_STARTED);
        taskRepository.save(task);
    }


    public TaskDto convertToTaskDto(Task task) {return modelMapper.map(task, TaskDto.class);}


}
