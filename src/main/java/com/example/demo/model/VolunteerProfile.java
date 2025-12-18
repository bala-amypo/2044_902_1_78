package com.example.demo.VolunteerProfile;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "volunteer_profile",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "volunteerId"),
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "phone")
    }
)
public class VolunteerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String volunteerId;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Enumerated(EnumType.STRING)
    private AvailabilityStatus availabilityStatus;

    private LocalDateTime createdAt = LocalDateTime.now();

}

