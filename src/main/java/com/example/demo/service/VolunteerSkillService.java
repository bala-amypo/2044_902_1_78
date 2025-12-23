package com.example.demo.service;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.repository.VolunteerSkillRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerSkillService {

    private final VolunteerSkillRecordRepository repository;

    public VolunteerSkillService(VolunteerSkillRecordRepository repository) {
        this.repository = repository;
    }

    public VolunteerSkillRecord create(VolunteerSkillRecord skill) {
        return repository.save(skill);
    }

    public List<VolunteerSkillRecord> getAll() {
        return repository.findAll();
    }

    public VolunteerSkillRecord getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill not found"));
    }

    public VolunteerSkillRecord update(Long id, VolunteerSkillRecord skill) {
        VolunteerSkillRecord existing = getById(id);
        existing.setSkillName(skill.getSkillName());
        existing.setSkillLevel(skill.getSkillLevel());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
