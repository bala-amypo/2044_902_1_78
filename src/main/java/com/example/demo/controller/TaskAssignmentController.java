package com.example.demo.controller;

import com.example.demo.model.TaskAssignment;
import com.example.demo.service.TaskAssignmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task-assignments")
public class TaskAssignmentController {

    private final TaskAssignmentService service;

    public TaskAssignmentController(TaskAssignmentService service) {
        this.service = service;
    }

    @PostMapping
    public TaskAssignment create(@RequestBody TaskAssignment assignment) {
        return service.create(assignment);
    }

    @GetMapping
    public List<TaskAssignment> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public TaskAssignment getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public TaskAssignment update(
            @PathVariable Long id,
            @RequestBody TaskAssignment assignment) {
        return service.update(id, assignment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
