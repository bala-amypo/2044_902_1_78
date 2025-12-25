package com.example.demo.service;

import com.example.demo.model.TaskAssignment;
import com.example.demo.repository.TaskAssignmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskAssignmentService {

    private final TaskAssignmentRepository repo;

    public TaskAssignmentService(TaskAssignmentRepository repo) {
        this.repo = repo;
    }

    public TaskAssignment create(TaskAssignment assignment) {
        return repo.save(assignment);
    }

    public List<TaskAssignment> getAll() {
        return repo.findAll();
    }

    public TaskAssignment getById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public TaskAssignment update(Long id, TaskAssignment updated) {
        TaskAssignment existing = getById(id);
        existing.setTaskId(updated.getTaskId());
        existing.setVolunteerId(updated.getVolunteerId());
        existing.setStatus(updated.getStatus());
        return repo.save(existing);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
