package com.example.demo.controller;

import com.example.demo.dto.AssignmentStatusUpdateRequest;
import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.service.TaskAssignmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
@Tag(name = "Assignments", description = "Assignment management endpoints")
public class TaskAssignmentController {
    
    private final TaskAssignmentService taskAssignmentService;
    
    public TaskAssignmentController(TaskAssignmentService taskAssignmentService) {
        this.taskAssignmentService = taskAssignmentService;
    }
    
    @PostMapping("/{volunteerId}/{taskId}")
    @Operation(summary = "Assign volunteer to task")
    public ResponseEntity<TaskAssignmentRecord> assignVolunteerToTask(@PathVariable Long volunteerId, 
                                                                     @PathVariable Long taskId) {
        TaskAssignmentRecord assignment = taskAssignmentService.assignTask(taskId);
        return ResponseEntity.ok(assignment);
    }
    
    @PutMapping("/{id}/status")
    @Operation(summary = "Update assignment status")
    public ResponseEntity<TaskAssignmentRecord> updateAssignmentStatus(@PathVariable Long id,
                                                                      @RequestBody AssignmentStatusUpdateRequest request) {
        TaskAssignmentRecord assignment = taskAssignmentService.updateAssignmentStatus(id, request);
        return ResponseEntity.ok(assignment);
    }
    
    @GetMapping("/volunteer/{volunteerId}")
    @Operation(summary = "Get assignments for volunteer")
    public ResponseEntity<List<TaskAssignmentRecord>> getAssignmentsForVolunteer(@PathVariable Long volunteerId) {
        List<TaskAssignmentRecord> assignments = taskAssignmentService.getAssignmentsByVolunteer(volunteerId);
        return ResponseEntity.ok(assignments);
    }
    
    @GetMapping("/task/{taskId}")
    @Operation(summary = "Get assignments for task")
    public ResponseEntity<List<TaskAssignmentRecord>> getAssignmentsForTask(@PathVariable Long taskId) {
        List<TaskAssignmentRecord> assignments = taskAssignmentService.getAssignmentsByTask(taskId);
        return ResponseEntity.ok(assignments);
    }
}