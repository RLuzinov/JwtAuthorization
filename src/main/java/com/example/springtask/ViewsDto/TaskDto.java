package com.example.springtask.ViewsDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    private String nameTask;

    private String description;


    private String status;

    String user;
}
