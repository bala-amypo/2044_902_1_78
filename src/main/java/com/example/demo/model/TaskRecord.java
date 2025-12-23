package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TaskRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String taskCode;

    private String taskName;
    private String requiredSkill;
    private String requiredSkillLevel;
    private String priority;
    private String status;

    private LocalDateTime createdAt;

    @PrePersist
    void onCreate() {
        createdAt = LocalDateTime.now();
        status = "OPEN";
    }

    // getters & setters
    public String getTaskName() {
    return taskName;
}

public void setTaskName(String taskName) {
    this.taskName = taskName;
}

public String getRequiredSkill() {
    return requiredSkill;
}

public void setRequiredSkill(String requiredSkill) {
    this.requiredSkill = requiredSkill;
}

}