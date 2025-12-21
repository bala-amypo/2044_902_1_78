package com.example.demo.service;

import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.repository.AssignmentEvaluationRecordRepository;
import org.springframework.stereotype.Service;

@Service
public class AssignmentEvaluationService {

    private final AssignmentEvaluationRecordRepository repo;

    public AssignmentEvaluationService(AssignmentEvaluationRecordRepository repo) {
        this.repo = repo;
    }

    public AssignmentEvaluationRecord evaluate(AssignmentEvaluationRecord e) {
        return repo.save(e);
    }
}