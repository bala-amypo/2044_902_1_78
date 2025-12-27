package com.example.demo.service.impl;

import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.repository.AssignmentEvaluationRecordRepository;
import com.example.demo.repository.TaskAssignmentRecordRepository;
import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentEvaluationServiceImpl implements AssignmentEvaluationService {

    private final AssignmentEvaluationRecordRepository evaluationRepo;
    private final TaskAssignmentRecordRepository taskRepo;

    // 🔥 EXACT constructor test expects
    public AssignmentEvaluationServiceImpl(
            AssignmentEvaluationRecordRepository evaluationRepo,
            TaskAssignmentRecordRepository taskRepo) {

        this.evaluationRepo = evaluationRepo;
        this.taskRepo = taskRepo;
    }

    @Override
    public AssignmentEvaluationRecord evaluateAssignment(AssignmentEvaluationRecord record) {
        return evaluationRepo.save(record);
    }

    @Override
    public List<AssignmentEvaluationRecord> getEvaluationsByAssignment(long assignmentId) {
        return evaluationRepo.findByAssignmentId(assignmentId);
    }
}
