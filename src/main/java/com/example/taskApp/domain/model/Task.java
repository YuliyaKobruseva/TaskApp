package com.example.taskApp.domain.model;

import com.example.taskApp.domain.model.enums.TaskStatus;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "tasks")
public class Task {
    @Id
    private String id;
    private String title;
    private String description;
    @Field("due_date")
    private LocalDate dueDate;
    private List<String> tags;
    private TaskStatus status;
}
