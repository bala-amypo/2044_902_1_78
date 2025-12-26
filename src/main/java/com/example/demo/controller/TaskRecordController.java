package com.example.demo.controller;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.model.TaskRecord;
import com.example.demo.service.TaskAssignmentService;
import com.example.demo.service.TaskRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@Tag(name = "Tasks", description = "Task management endpoints")
public class TaskRecordController {
    
    private final TaskRecordService taskRecordService;
    private final TaskAssignmentService taskAssignmentService;
    
    public TaskRecordController(TaskRecordService taskRecordService, TaskAssignmentService taskAssignmentService) {
        this.taskRecordService = taskRecordService;
        this.taskAssignmentService = taskAssignmentService;
    }
    
    @PostMapping
    @Operation(summary = "Create new task")
    public ResponseEntity<TaskRecord> createTask(@RequestBody TaskRecord task) {
        TaskRecord createdTask = taskRecordService.createTask(task);
        return ResponseEntity.ok(createdTask);
    }
    
    @GetMapping("/open")
    @Operation(summary = "Get open tasks")
    public ResponseEntity<List<TaskRecord>> getOpenTasks() {
        List<TaskRecord> tasks = taskRecordService.getOpenTasks();
        return ResponseEntity.ok(tasks);
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Get task by ID")
    public ResponseEntity<TaskRecord> getTaskById(@PathVariable Long id) {
        TaskRecord task = taskRecordService.getTaskById(id);
        return ResponseEntity.ok(task);
    }
    
    @PostMapping("/{taskId}/assign")
    @Operation(summary = "Assign task to volunteer")
    public ResponseEntity<TaskAssignmentRecord> assignTask(@PathVariable Long taskId) {
        TaskAssignmentRecord assignment = taskAssignmentService.assignTask(taskId);
        return ResponseEntity.ok(assignment);
    }
}