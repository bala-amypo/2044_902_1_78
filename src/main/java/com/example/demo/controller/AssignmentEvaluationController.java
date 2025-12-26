package com.example.demo.controller;

import com.example.demo.dto.EvaluationRequest;
import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.service.AssignmentEvaluationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluations")
@Tag(name = "Evaluations", description = "Evaluation management endpoints")
public class AssignmentEvaluationController {
    
    private final AssignmentEvaluationService assignmentEvaluationService;
    
    public AssignmentEvaluationController(AssignmentEvaluationService assignmentEvaluationService) {
        this.assignmentEvaluationService = assignmentEvaluationService;
    }
    
    @PostMapping("/{assignmentId}")
    @Operation(summary = "Create evaluation for assignment")
    public ResponseEntity<AssignmentEvaluationRecord> createEvaluation(@PathVariable Long assignmentId,
                                                                       @RequestBody EvaluationRequest request) {
        AssignmentEvaluationRecord evaluation = new AssignmentEvaluationRecord();
        evaluation.setAssignmentId(assignmentId);
        evaluation.setRating(request.getRating());
        evaluation.setFeedback(request.getFeedback());
        
        AssignmentEvaluationRecord savedEvaluation = assignmentEvaluationService.evaluateAssignment(evaluation);
        return ResponseEntity.ok(savedEvaluation);
    }
    
    @GetMapping("/volunteer/{volunteerId}")
    @Operation(summary = "Get evaluations for volunteer")
    public ResponseEntity<List<AssignmentEvaluationRecord>> getEvaluationsForVolunteer(@PathVariable Long volunteerId) {
        List<AssignmentEvaluationRecord> evaluations = assignmentEvaluationService.getEvaluationsForVolunteer(volunteerId);
        return ResponseEntity.ok(evaluations);
    }
}