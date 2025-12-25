package com.example.demo.service;

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

    public VolunteerProfile create(VolunteerProfile volunteer) {
        return repo.save(volunteer);
    }

    public List<VolunteerProfile> getAll() {
        return repo.findAll();
    }

    public VolunteerProfile getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Volunteer not found"));
    }

    public VolunteerProfile update(Long id, VolunteerProfile volunteer) {
        VolunteerProfile existing = getById(id);
        existing.setFullName(volunteer.getFullName());
        existing.setEmail(volunteer.getEmail());
        existing.setAvailabilityStatus(volunteer.getAvailabilityStatus());
        return repo.save(existing);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
