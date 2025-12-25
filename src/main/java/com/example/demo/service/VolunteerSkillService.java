package com.example.demo.service;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.repository.VolunteerSkillRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerSkillService {

    private final VolunteerSkillRecordRepository repo;

    public VolunteerSkillService(VolunteerSkillRecordRepository repo) {
        this.repo = repo;
    }

    // CREATE
    public VolunteerSkillRecord create(VolunteerSkillRecord skill) {
        return repo.save(skill);
    }

    // READ ALL
    public List<VolunteerSkillRecord> getAll() {
        return repo.findAll();
    }

    // READ BY ID
    public VolunteerSkillRecord getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill not found"));
    }

    // UPDATE
    public VolunteerSkillRecord update(Long id, VolunteerSkillRecord skill) {
        VolunteerSkillRecord existing = getById(id);
        existing.setSkillName(skill.getSkillName());
        existing.setSkillLevel(skill.getSkillLevel());
        return repo.save(existing);
    }

    // DELETE
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
