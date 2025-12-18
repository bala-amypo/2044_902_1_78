package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AssignmentEvaluationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long assignmentId;

    private Integer rating; // 1–5

    private String feedback;

    private LocalDateTime evaluatedAt;

    @PrePersist
    void onEvaluate() {
        evaluatedAt = LocalDateTime.now();
    }

    // getters & setters
}
