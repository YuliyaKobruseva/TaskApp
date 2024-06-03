package com.example.taskApp.app.services.interfaces;

import com.example.taskApp.domain.model.Task;
import com.example.taskApp.domain.repository.TaskRepository;
import com.example.taskApp.interfaces.rest.dto.NewTaskRequest;
import com.example.taskApp.util.TestRequestModels;
import com.example.taskApp.util.TestTaskModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class INewTaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private INewTaskService newTaskService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void given_valid_request_when_createTask_then_task_is_created() {
        // Arrange
        NewTaskRequest request = TestRequestModels.createNewTaskRequest();
        Task expectedTask = TestTaskModel.createExpectedTask(request);

        when(taskRepository.save(any(Task.class))).thenReturn(expectedTask);

        // Act
        Task createdTask = newTaskService.createTask(request);

        // Assert
        assertEquals(expectedTask.getTitle(), createdTask.getTitle());
        assertEquals(expectedTask.getDescription(), createdTask.getDescription());
        assertEquals(expectedTask.getDueDate(), createdTask.getDueDate());
        assertEquals(expectedTask.getTags(), createdTask.getTags());
        assertEquals(expectedTask.getStatus(), createdTask.getStatus());
    }


}