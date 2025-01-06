package com.example.springtask.ViewsDto;


import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CommentRequesDto {

    private String commentBody;

    private String theme;
}
