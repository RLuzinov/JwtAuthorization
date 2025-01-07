package com.example.springtask.repository;

import com.example.springtask.ViewsDto.TaskDto;
import com.example.springtask.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Query(nativeQuery = true, value =
            "SELECT t.name_task, t.description, t.status, u.username \n" +
                    "FROM tasks t \n" +
                    "JOIN users u ON t.id_user = u.id \n"+
                    "WHERE t.id = :id")
    Optional<TaskDto> findByTask_Id(int id);

    @Query(nativeQuery = true, value =
            "SELECT t.name_task, t.description, t.status, u.username \n" +
            "FROM tasks t \n" +
            "JOIN users u ON t.id_user = u.id ")
//    @Query("SELECT t.nameTask, t.description, t.status, t.user.username FROM Task t")
    List<TaskDto> findAllTasks();
}
