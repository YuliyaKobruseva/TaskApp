package com.example.taskApp.app.services.interfaces;

import com.example.taskApp.app.services.GetTasksService;
import com.example.taskApp.domain.model.Task;
import com.example.taskApp.domain.repository.TaskRepository;
import com.example.taskApp.interfaces.rest.dto.TaskResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IGetTasksService implements GetTasksService {
    private final TaskRepository taskRepository;

    public IGetTasksService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskResponse> getTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private TaskResponse convertToDto(Task task) {
        TaskResponse dto = new TaskResponse();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setDueDate(task.getDueDate());
        dto.setTags(task.getTags());
        dto.setStatus(task.getStatus().name());
        return dto;
    }

}
