package com.example.taskApp.interfaces.rest;

import com.example.taskApp.app.services.GetTasksService;
import com.example.taskApp.app.services.NewTaskService;
import com.example.taskApp.domain.model.Task;
import com.example.taskApp.interfaces.rest.dto.NewTaskRequest;
import com.example.taskApp.interfaces.rest.dto.TaskResponse;
import com.example.taskApp.util.TestRequestModels;
import com.example.taskApp.util.TestTaskModel;
import com.example.taskApp.util.TestResponseModels;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TaskController.class)
class TaskControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NewTaskService newTaskService;

    @MockBean
    private GetTasksService getTasksService;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void given_valid_request_when_createTask_then_task_is_created() throws Exception {
        // Arrange
        NewTaskRequest request = objectMapper.readValue(new ClassPathResource("jsons/newTaskRequest.json").getFile(), NewTaskRequest.class);
        Task expectedTask = TestTaskModel.createExpectedTask(request);

        when(newTaskService.createTask(any(NewTaskRequest.class))).thenReturn(expectedTask);

        // Act & Assert
        mockMvc.perform(post("/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(expectedTask)));
    }

    @Test
    public void when_getAllTasks_then_return_all_tasks() throws Exception {
        // Arrange
        TaskResponse taskResponse1 = TestResponseModels.createTaskResponse1();

        TaskResponse taskResponse2 = TestResponseModels.createTaskResponse2();

        List<TaskResponse> taskResponses = Arrays.asList(taskResponse1, taskResponse2);

        when(getTasksService.getTasks()).thenReturn(taskResponses);

        // Act & Assert
        mockMvc.perform(get("/tasks/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(taskResponses)));
    }

}