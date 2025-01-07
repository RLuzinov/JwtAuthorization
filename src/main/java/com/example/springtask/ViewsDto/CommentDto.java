package com.example.springtask.ViewsDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

    private String taskName;

    private String user;

    private String commentBody;

    private String theme;







}
