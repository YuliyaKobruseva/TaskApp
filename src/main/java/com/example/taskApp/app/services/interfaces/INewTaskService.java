package com.example.taskApp.app.services.interfaces;

import com.example.taskApp.app.services.NewTaskService;
import com.example.taskApp.domain.model.Task;
import com.example.taskApp.domain.model.enums.TaskStatus;
import com.example.taskApp.domain.repository.TaskRepository;
import com.example.taskApp.interfaces.rest.dto.NewTaskRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class INewTaskService implements NewTaskService {
    private final TaskRepository taskRepository;

    public INewTaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(NewTaskRequest request) {
        Task task = Task.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .dueDate(request.getDueDate())
                .tags(request.getTags())
                .status(TaskStatus.CREATED)
                .build();
        return taskRepository.save(task);
    }
}
