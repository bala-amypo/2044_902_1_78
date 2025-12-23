package com.example.demo.controller;

import com.example.demo.model.TaskRecord;
import com.example.demo.service.TaskRecordService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskRecordController {

    private final TaskRecordService service;

    public TaskRecordController(TaskRecordService service) {
        this.service = service;
    }

    @PostMapping
    public TaskRecord createTask(@RequestBody TaskRecord task) {
        return service.createTask(task);
    }

    @GetMapping
    public List<TaskRecord> getAllTasks() {
        return service.getAllTasks();
    }

    @GetMapping("/{id}")
    public TaskRecord getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public TaskRecord update(
            @PathVariable Long id,
            @RequestBody TaskRecord task) {
        return service.update(id, task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteTask(id);
    }
}
