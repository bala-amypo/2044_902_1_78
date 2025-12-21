package com.example.demo.service;

import com.example.demo.model.TaskRecord;
import com.example.demo.repository.TaskRecordRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskRecordService {

    private final TaskRecordRepository repository;

    public TaskRecordService(TaskRecordRepository repository) {
        this.repository = repository;
    }

    public TaskRecord createTask(TaskRecord task) {
        return repository.save(task);
    }
}