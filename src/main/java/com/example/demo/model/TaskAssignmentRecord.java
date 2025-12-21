package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TaskAssignmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long taskId;

    private Long volunteerId;

    private LocalDateTime assignedAt;

    private String status; // ACTIVE / COMPLETED / CANCELLED

    private String notes;

    @PrePersist
    void onAssign() {
        assignedAt = LocalDateTime.now();
        status = "ACTIVE";
    }

    // getters & setters
    public void setTaskId(Long taskId) {
    this.taskId = taskId;
}

public void setVolunteerId(Long volunteerId) {
    this.volunteerId = volunteerId;
}

}
