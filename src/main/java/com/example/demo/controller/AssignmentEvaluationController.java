package com.example.demo.controller;

import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.service.AssignmentEvaluationRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignment-evaluations")
public class AssignmentEvaluationRecordController {

    private final AssignmentEvaluationRecordService service;

    public AssignmentEvaluationRecordController(
            AssignmentEvaluationRecordService service) {
        this.service = service;
    }

    @PostMapping
    public AssignmentEvaluationRecord create(
            @RequestBody AssignmentEvaluationRecord r) {
        return service.create(r);
    }

    @GetMapping
    public List<AssignmentEvaluationRecord> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public AssignmentEvaluationRecord getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public AssignmentEvaluationRecord update(
            @PathVariable Long id,
            @RequestBody AssignmentEvaluationRecord r) {
        return service.update(id, r);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
