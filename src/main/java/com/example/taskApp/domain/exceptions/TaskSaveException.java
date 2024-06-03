package com.example.taskApp.domain.exceptions;

public class TaskSaveException extends RuntimeException {
    public TaskSaveException(String message, Throwable cause) {
        super(message, cause);
    }
}
