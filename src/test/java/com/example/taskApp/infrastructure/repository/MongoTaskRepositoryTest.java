package com.example.taskApp.infrastructure.repository;

import com.example.taskApp.domain.model.Task;
import com.example.taskApp.util.TestTaskModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class MongoTaskRepositoryTest {
    @Mock
    private MongoTemplate mongoTemplate;

    @InjectMocks
    private MongoTaskRepository mongoTaskRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void given_task_when_save_then_task_is_saved() {
        // Arrange
        Task task = TestTaskModel.createTask1();
        when(mongoTemplate.save(any(Task.class))).thenReturn(task);

        // Act
        Task savedTask = mongoTaskRepository.save(task);

        // Assert
        assertEquals(task.getId(), savedTask.getId());
        assertEquals(task.getTitle(), savedTask.getTitle());
        assertEquals(task.getDescription(), savedTask.getDescription());
        assertEquals(task.getDueDate(), savedTask.getDueDate());
        assertEquals(task.getTags(), savedTask.getTags());
        assertEquals(task.getStatus(), savedTask.getStatus());
    }

    @Test
    public void when_findAll_then_return_all_tasks() {
        // Arrange
        Task task1 = TestTaskModel.createTask1();
        Task task2 = TestTaskModel.createTask2();
        when(mongoTemplate.findAll(Task.class)).thenReturn(Arrays.asList(task1, task2));

        // Act
        List<Task> tasks = mongoTaskRepository.findAll();

        // Assert
        assertEquals(2, tasks.size());
        assertEquals(task1.getId(), tasks.get(0).getId());
        assertEquals(task2.getId(), tasks.get(1).getId());
    }
}