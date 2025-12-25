package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class TaskAssignmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long taskId;
    private Long volunteerId;
    private String status;

    // getters
    public Long getId() { return id; }
    public Long getTaskId() { return taskId; }
    public Long getVolunteerId() { return volunteerId; }
    public String getStatus() { return status; }

    // setters
    public void setId(Long id) { this.id = id; }
    public void setTaskId(Long taskId) { this.taskId = taskId; }
    public void setVolunteerId(Long volunteerId) { this.volunteerId = volunteerId; }
    public void setStatus(String status) { this.status = status; }
}
