package com.example.springtask.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "comment_body")
    private String commentBody;

    @Column(name = "comment_theme")
    private String theme;

    @ManyToOne
    @JoinColumn(name = "id_task")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;


}
