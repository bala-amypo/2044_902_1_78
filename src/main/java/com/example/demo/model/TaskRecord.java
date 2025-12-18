package com.example.demo.model;

import jakarta.persistance.*;
import java. time.LocalDateTime;
@Entity
public class TakeRecord {

    @Id
    @generatedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String taskCode;
    private String taskName;
    private String requiredSkill;
    private String requiredSkillLevel;
    private String priority;
    private String status;
    private LocalDateTime createdAt;

    @Prepersist
    void onCreate() {
        createdAt = LocalDateTime.now();
            status = "OPEN";
    }

}