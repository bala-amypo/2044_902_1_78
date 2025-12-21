package com.example.demo.service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.repository.VolunteerSkillRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerSkillService {

    private final VolunteerSkillRecordRepository repository;

    public VolunteerSkillService(VolunteerSkillRecordRepository repo) {
        this.repo = repo;
    }

    public VolunteerSkillRecord addSkill(VolunteerSkillRecord skill) {
        if (repo.existsByVolunteerIdAndSkillName(
                skill.getVolunteerId(), skill.getSkillName())) {
            throw new BadRequestException("Skill already exists");
        }
        return repo.save(skill);
    }

    public List<VolunteerSkillRecord> getSkills(Long volunteerId) {
        return repo.findByVolunteerId(volunteerId);
    }

    public VolunteerSkillRecord create(VolunteerSkillRecord skill) {
    return repository.save(skill);
}
}