package com.example.demo.service;

import com.example.demo.model.VolunteerProfile;
import com.example.demo.repository.VolunteerProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerProfileService {

    private final VolunteerProfileRepository repository;

    public VolunteerProfileService(VolunteerProfileRepository repository) {
        this.repository = repository;
    }

    public VolunteerProfile save(VolunteerProfile v) {
        return repository.save(v);
    }

    public List<VolunteerProfile> getAll() {
        return repository.findAll();
    }

    public VolunteerProfile getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Volunteer not found"));
    }

    public VolunteerProfile update(Long id, VolunteerProfile v) {
        VolunteerProfile existing = getById(id);
        existing.setFullName(v.getFullName());
        existing.setAvailabilityStatus(v.getAvailabilityStatus());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
