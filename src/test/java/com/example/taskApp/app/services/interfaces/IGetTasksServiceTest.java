package com.example.taskApp.app.services.interfaces;

import com.example.taskApp.domain.model.Task;
import com.example.taskApp.domain.repository.TaskRepository;
import com.example.taskApp.interfaces.rest.dto.TaskResponse;
import com.example.taskApp.util.TestTaskModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class IGetTasksServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private IGetTasksService getTasksService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void when_getTasks_then_return_all_tasks() {
        // Arrange
        Task task1 = TestTaskModel.createTask1();
        Task task2 = TestTaskModel.createTask2();

        when(taskRepository.findAll()).thenReturn(Arrays.asList(task1, task2));

        // Act
        List<TaskResponse> taskResponses = getTasksService.getTasks();

        // Assert
        assertEquals(2, taskResponses.size());
        assertEquals("1", taskResponses.get(0).getId());
        assertEquals("Task 1", taskResponses.get(0).getTitle());
        assertEquals("Description 1", taskResponses.get(0).getDescription());
        assertEquals(LocalDate.now().plusDays(1), taskResponses.get(0).getDueDate());
        assertEquals(Arrays.asList("tag1", "tag2"), taskResponses.get(0).getTags());
        assertEquals("CREATED", taskResponses.get(0).getStatus());

        assertEquals("2", taskResponses.get(1).getId());
        assertEquals("Task 2", taskResponses.get(1).getTitle());
        assertEquals("Description 2", taskResponses.get(1).getDescription());
        assertEquals(LocalDate.now().plusDays(2), taskResponses.get(1).getDueDate());
        assertEquals(Arrays.asList("tag3", "tag4"), taskResponses.get(1).getTags());
        assertEquals("COMPLETED", taskResponses.get(1).getStatus());
    }
}