package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.repository.VolunteerSkillRecordRepository;

@Service
public class VolunteerSkillService {

    private final VolunteerSkillRecordRepository repo;

    public VolunteerSkillService(VolunteerSkillRecordRepository repo) {
        this.repo = repo;
    }

    public VolunteerSkillRecord create(VolunteerSkillRecord v) {
        return repo.save(v);
    }

    public List<VolunteerSkillRecord> getAll() {
        return repo.findAll();
    }

    public VolunteerSkillRecord getById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public VolunteerSkillRecord update(Long id, VolunteerSkillRecord v) {
        VolunteerSkillRecord existing = getById(id);
        existing.setSkillName(v.getSkillName());
        existing.setSkillLevel(v.getSkillLevel());
        existing.setVolunteerId(v.getVolunteerId());
        return repo.save(existing);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
