package com.example.demo.service;

import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.repository.AssignmentEvaluationRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentEvaluationService {

    private final AssignmentEvaluationRecordRepository repo;

    public AssignmentEvaluationRecordService(
            AssignmentEvaluationRecordRepository repo) {
        this.repo = repo;
    }

    public AssignmentEvaluationRecord create(AssignmentEvaluationRecord r) {
        return repo.save(r);
    }

    public List<AssignmentEvaluationRecord> getAll() {
        return repo.findAll();
    }

    public AssignmentEvaluationRecord getById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public AssignmentEvaluationRecord update(Long id,
            AssignmentEvaluationRecord updated) {

        AssignmentEvaluationRecord existing = getById(id);
        existing.setRating(updated.getRating());
        existing.setFeedback(updated.getFeedback());
        existing.setTaskAssignmentId(updated.getTaskAssignmentId());
        return repo.save(existing);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
