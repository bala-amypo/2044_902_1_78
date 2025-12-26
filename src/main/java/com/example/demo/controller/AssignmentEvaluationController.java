package com.example.demo.controller;

import com.example.demo.dto.EvaluationRequest;
import com.example.demo.model.AssignmentEvaluationRecord;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluations")
@Tag(name = "Evaluations", description = "Evaluation management endpoints")
public class AssignmentEvaluationController {
    
    @PostMapping("/{assignmentId}")
    @Operation(summary = "Create evaluation for assignment")
    public ResponseEntity<String> createEvaluation(@PathVariable Long assignmentId,
                                                   @RequestBody EvaluationRequest request) {
        return ResponseEntity.ok("Evaluation created");
    }
    
    @GetMapping("/volunteer/{volunteerId}")
    @Operation(summary = "Get evaluations for volunteer")
    public ResponseEntity<String> getEvaluationsForVolunteer(@PathVariable Long volunteerId) {
        return ResponseEntity.ok("Evaluations retrieved");
    }
}