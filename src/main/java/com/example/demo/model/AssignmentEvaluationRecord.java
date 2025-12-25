package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class AssignmentEvaluationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long taskAssignmentId;
    private int rating;
    private String feedback;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getTaskAssignmentId() { return taskAssignmentId; }
    public void setTaskAssignmentId(Long taskAssignmentId) {
        this.taskAssignmentId = taskAssignmentId;
    }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public String getFeedback() { return feedback; }
    public void setFeedback(String feedback) { this.feedback = feedback; }
}
