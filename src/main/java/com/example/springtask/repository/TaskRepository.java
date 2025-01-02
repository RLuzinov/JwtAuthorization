package com.example.springtask.repository;

import com.example.springtask.ViewsDto.TaskDto;
import com.example.springtask.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    Optional<Task> findByUser_Id(int id);
}
