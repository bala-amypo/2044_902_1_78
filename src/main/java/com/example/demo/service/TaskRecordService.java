package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.TaskRecord;
import com.example.demo.repository.TaskRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskRecordService {

    private final TaskRecordRepository repo;

    public TaskRecordService(TaskRecordRepository repo) {
        this.repo = repo;
    }

    public TaskRecord create(TaskRecord task) {
        return repoitory.save(task);
    }

    public TaskRecord getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));
    }

    public List<TaskRecord> getOpenTasks() {
        return repo.findByStatus("OPEN");
    }
}