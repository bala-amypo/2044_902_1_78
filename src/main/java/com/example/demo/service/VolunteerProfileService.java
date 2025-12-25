package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.VolunteerProfile;
import com.example.demo.repository.VolunteerProfileRepository;

@Service
public class VolunteerProfileService {

    private final VolunteerProfileRepository repo;

    public VolunteerProfileService(VolunteerProfileRepository repo) {
        this.repo = repo;
    }

    public VolunteerProfile create(VolunteerProfile v) {
        return repo.save(v);
    }

    public List<VolunteerProfile> getAll() {
        return repo.findAll();
    }

    public VolunteerProfile getById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public VolunteerProfile update(Long id, VolunteerProfile v) {
        VolunteerProfile existing = getById(id);
        existing.setFullName(v.getFullName());
        existing.setEmail(v.getEmail());
        existing.setPhone(v.getPhone());
        return repo.save(existing);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
