package com.example.springtask.services;

import com.example.springtask.ViewsDto.TaskRequsestDto;
import com.example.springtask.models.Status;
import com.example.springtask.models.StatusVariable;
import com.example.springtask.models.Task;
import com.example.springtask.repository.TaskRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class TaskService {
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
    @Transactional
    public boolean updateStatus(int id, StatusVariable status) {
        Task task = taskRepository.findById(id).get();
        if(status.getStatus().equals("started") || status.getStatus().equals("finished")){
            if(status.getStatus().equals("started"))
            {task.setStatus(Status.STARTED);}
            else{task.setStatus(Status.FINISHED);}
             taskRepository.save(
                     new Task(task.getId(),
                             task.getNameTask(),
                             task.getDescription(),
                             task.getStatus(),
                             task.getUser()));
            return true;}
        else{return false;}

    }



}
