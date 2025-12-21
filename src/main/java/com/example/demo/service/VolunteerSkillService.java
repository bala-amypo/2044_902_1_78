package com.example.demo.service;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.repository.VolunteerSkillRecordRepository;
import org.springframework.stereotype.Service;

@Service
public class VolunteerSkillService {

    private final VolunteerSkillRecordRepository repository;

    public VolunteerSkillService(VolunteerSkillRecordRepository repository) {
        this.repository = repository;
    }

    public VolunteerSkillRecord create(VolunteerSkillRecord skill) {
        return repository.save(skill);
    }
}
