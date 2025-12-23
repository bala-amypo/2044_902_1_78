package com.example.demo.service;

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

    public List<TaskRecord> getAllTasks() {
        return repository.findAll();
    }

    public TaskRecord getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public TaskRecord update(Long id, TaskRecord task) {
        TaskRecord existing = getById(id);
        existing.setTaskName(task.getTaskName());
        existing.setRequiredSkill(task.getRequiredSkill());
        return repository.save(existing);
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}
