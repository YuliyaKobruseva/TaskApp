package com.example.taskApp.app.services.interfaces;

import com.example.taskApp.app.services.NewTaskService;
import com.example.taskApp.domain.exceptions.TaskSaveException;
import com.example.taskApp.domain.model.Task;
import com.example.taskApp.domain.model.enums.TaskStatus;
import com.example.taskApp.domain.repository.TaskRepository;
import com.example.taskApp.interfaces.rest.TaskController;
import com.example.taskApp.interfaces.rest.dto.NewTaskRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class INewTaskService implements NewTaskService {
    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    private final TaskRepository taskRepository;

    public INewTaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(NewTaskRequest request) {

        logger.debug("Creating task with title: {}", request.getTitle());
        try {
        Task task = Task.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .dueDate(request.getDueDate())
                .tags(request.getTags())
                .status(TaskStatus.CREATED)
                .build();
        Task savedTask = taskRepository.save(task);
        logger.debug("Task created with id: {}", savedTask.getId());
        return savedTask;
        } catch (Exception e) {
            logger.error("Error saving task to database", e);
            throw new TaskSaveException("Failed to save task to database", e);
        }
    }
}
