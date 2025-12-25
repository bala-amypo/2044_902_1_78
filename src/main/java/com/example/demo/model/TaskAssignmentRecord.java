package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class TaskAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long taskId;
    private Long volunteerId;
    private String status; // ASSIGNED / COMPLETED

    // getters & setters
}
