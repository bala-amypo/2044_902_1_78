package com.example.demo.service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.repository.VolunteerProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerProfileService {

    private final VolunteerProfileRepository repo;

    public VolunteerProfileService(VolunteerProfileRepository repo) {
        this.repo = repo;
    }

    public VolunteerProfile createVolunteer(VolunteerProfile v) {
        if (repo.existsByEmail(v.getEmail())) {
            throw new BadRequestException("Email already exists");
        }
        v.setAvailabilityStatus("AVAILABLE");
        return repo.save(v);
    }

    public VolunteerProfile getVolunteer(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Volunteer not found"));
    }

    public List<VolunteerProfile> getAll() {
        return repo.findAll();
    }

    public VolunteerProfile updateAvailability(Long id, String status) {
        VolunteerProfile v = getVolunteer(id);
        v.setAvailabilityStatus(status);
        return repo.save(v);
    }
}