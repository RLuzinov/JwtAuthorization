package com.example.springtask.repository;

import com.example.springtask.ViewsDto.CommentDto;
import com.example.springtask.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
 public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query(nativeQuery = true, value = "SELECT  t.name_task, u.username, c.comment_body, c.comment_theme  \n" +
            "FROM comments c \n" +
            "JOIN users u ON c.id_user = u.id \n" +
            "JOIN tasks t ON c.id_task = t.id \n" +
            "WHERE t.id = :id;")
    List<CommentDto> findByCommentByTitleId(int id);


}
