package com.example.taskApp.interfaces.rest.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Data
@Getter
@Setter
public class TaskResponse {
    private String id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private List<String> tags;
    private String status;
}
