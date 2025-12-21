package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.TaskRecord;
import com.example.demo.repository.TaskRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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


    public TaskRecord getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));
    }

    public List<TaskRecord> getOpenTasks() {
        return repository.findByStatus("OPEN");
    }