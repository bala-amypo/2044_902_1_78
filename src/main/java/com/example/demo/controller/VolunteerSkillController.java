package com.example.demo.controller;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.service.VolunteerSkillService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@Tag(name = "Skills", description = "Volunteer skill management endpoints")
public class VolunteerSkillController {
    
    private final VolunteerSkillService volunteerSkillService;
    
    public VolunteerSkillController(VolunteerSkillService volunteerSkillService) {
        this.volunteerSkillService = volunteerSkillService;
    }
    
    @GetMapping("/volunteer/{volunteerId}")
    @Operation(summary = "Get skills for volunteer")
    public ResponseEntity<List<VolunteerSkillRecord>> getSkillsByVolunteer(@PathVariable Long volunteerId) {
        List<VolunteerSkillRecord> skills = volunteerSkillService.getSkillsByVolunteer(volunteerId);
        return ResponseEntity.ok(skills);
    }
    
    @PostMapping
    @Operation(summary = "Add or update skill")
    public ResponseEntity<VolunteerSkillRecord> addOrUpdateSkill(@RequestBody VolunteerSkillRecord skill) {
        VolunteerSkillRecord savedSkill = volunteerSkillService.addOrUpdateSkill(skill);
        return ResponseEntity.ok(savedSkill);
    }
}