package com.example.demo.service;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.repository.TaskAssignmentRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskAssignmentService {

    private final TaskAssignmentRecordRepository repo;

    public TaskAssignmentService(TaskAssignmentRecordRepository repo) {
        this.repo = repo;
    }

    public TaskAssignmentRecord create(TaskAssignmentRecord t) {
        return repo.save(t);
    }

    public List<TaskAssignmentRecord> getAll() {
        return repo.findAll();
    }

    public TaskAssignmentRecord getById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public TaskAssignmentRecord update(Long id, TaskAssignmentRecord updated) {
        TaskAssignmentRecord existing = getById(id);
        existing.setTaskId(updated.getTaskId());
        existing.setVolunteerId(updated.getVolunteerId());
        existing.setStatus(updated.getStatus());
        return repo.save(existing);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
