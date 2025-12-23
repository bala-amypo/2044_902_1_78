package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class VolunteerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String volunteerId;

    private String fullName;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String phone;

    private String availabilityStatus; // AVAILABLE / BUSY / INACTIVE

    private LocalDateTime createdAt;

    @PrePersist
    void onCreate() {
        createdAt = LocalDateTime.now();
    }

    // getters & setters
    public String getEmail() {
    return email;
}

public String getAvailabilityStatus() {
    return availabilityStatus;
}

public void setAvailabilityStatus(String availabilityStatus) {
    this.availabilityStatus = availabilityStatus;
}

public Long getId() {
    return id;
}

public String getFullName() {
    return fullName;
}

public void setFullName(String fullName) {
    this.fullName = fullName;
}

}