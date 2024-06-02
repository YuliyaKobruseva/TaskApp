package com.example.taskApp.interfaces.rest.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

@Data
public class NewTaskRequest {
    @NotBlank(message = "Title is mandatory")
    private String title;
    @NotBlank(message = "Description is mandatory")
    private String description;
    @NotNull(message = "Due date is mandatory")
    private LocalDate dueDate;
    private List<String> tags;
}
