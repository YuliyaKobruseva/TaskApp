package com.example.taskApp.infrastructure.repository;

import com.example.taskApp.domain.model.Task;
import com.example.taskApp.domain.repository.TaskRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MongoTaskRepository implements TaskRepository {
    private final MongoTemplate mongoTemplate;

    public MongoTaskRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Task save(Task task) {
        return mongoTemplate.save(task);
    }

    @Override
    public List<Task> findAll() {
        return mongoTemplate.findAll(Task.class);
    }
}
