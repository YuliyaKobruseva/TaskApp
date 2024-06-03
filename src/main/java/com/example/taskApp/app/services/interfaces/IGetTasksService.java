package com.example.taskApp.app.services.interfaces;

import com.example.taskApp.app.services.GetTasksService;
import com.example.taskApp.domain.model.Task;
import com.example.taskApp.domain.repository.TaskRepository;
import com.example.taskApp.interfaces.rest.TaskController;
import com.example.taskApp.interfaces.rest.dto.TaskResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IGetTasksService implements GetTasksService {
    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    private final TaskRepository taskRepository;

    public IGetTasksService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskResponse> getTasks() {
        logger.debug("Fetching all tasks");
        List<Task> tasks = taskRepository.findAll();
        List<TaskResponse> taskResponses = tasks.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        logger.info("Fetched {} tasks", taskResponses.size());
        return taskResponses;
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
