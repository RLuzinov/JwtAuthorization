package com.example.springtask.controller;

import com.example.springtask.ViewsDto.CommentDto;
import com.example.springtask.ViewsDto.CommentRequesDto;
import com.example.springtask.ViewsDto.TaskDto;

import com.example.springtask.models.Comment;
import com.example.springtask.repository.CommentRepository;
import com.example.springtask.repository.TaskRepository;
import com.example.springtask.services.CommentService;
import com.example.springtask.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

import java.util.List;


@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskRepository taskRepository;
    private final TaskService taskService;
    private final CommentRepository commentRepository;
    private final CommentService commentService;

    @GetMapping("/{id}")
    public TaskDto findById(@PathVariable int id) {
        return taskService.convertToTaskDto(
                taskRepository.findById(id)
                        .orElseThrow(()-> new NullPointerException(
                                String.format("Task for %s id not found", id))));
    }

    @GetMapping("/{id}/comment")
    public List<CommentDto> showComment(@PathVariable int id) {
//        commentService.convertToCommentDto(commentRepository.findByTask_Id(id).orElseThrow());
        return commentRepository.findByCommentByTitleId(id);
    }

    @PostMapping("/{id}/create_comment")
    public ResponseEntity<HttpStatus> createComment(@PathVariable int id, @RequestBody CommentRequesDto request, Principal principal){
        commentService.save(request, id, principal);
        return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
    }
}
