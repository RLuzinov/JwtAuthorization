package com.example.springtask.services;

import com.example.springtask.ViewsDto.CommentRequesDto;
import com.example.springtask.models.Comment;
import com.example.springtask.repository.CommentRepository;
import com.example.springtask.repository.TaskRepository;
import com.example.springtask.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    @Transactional
    public void save(CommentRequesDto request, int idTask, Principal principal) {
        Comment comment = new Comment();
        comment.setCommentBody(request.getCommentBody());
        comment.setTheme(request.getTheme());
        comment.setUser(userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new RuntimeException("User not found")));
        comment.setTask(taskRepository.findById(idTask)
                .orElseThrow(() -> new RuntimeException("Task not found")));
        commentRepository.save(comment);
    }

}
