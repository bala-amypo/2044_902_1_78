package com.example.demo.controller;

import com.example.demo.model.TaskAssignmentRecord;
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
    public TaskAssignmentRecord create(@RequestBody TaskAssignmentRecord t) {
        return service.create(t);
    }

    @GetMapping
    public List<TaskAssignmentRecord> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public TaskAssignmentRecord getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public TaskAssignmentRecord update(
            @PathVariable Long id,
            @RequestBody TaskAssignmentRecord t) {
        return service.update(id, t);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
