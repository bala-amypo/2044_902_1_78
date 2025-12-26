package com.example.demo.controller;

import com.example.demo.dto.AvailabilityUpdateRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/volunteers")
@Tag(name = "Volunteers", description = "Volunteer management endpoints")
public class VolunteerProfileController {
    
    private final VolunteerProfileService volunteerProfileService;
    
    public VolunteerProfileController(VolunteerProfileService volunteerProfileService) {
        this.volunteerProfileService = volunteerProfileService;
    }
    
    @GetMapping
    @Operation(summary = "Get all volunteers")
    public ResponseEntity<List<VolunteerProfile>> getAllVolunteers() {
        List<VolunteerProfile> volunteers = volunteerProfileService.getAllVolunteers();
        return ResponseEntity.ok(volunteers);
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Get volunteer by ID")
    public ResponseEntity<VolunteerProfile> getVolunteerById(@PathVariable Long id) {
        VolunteerProfile volunteer = volunteerProfileService.getVolunteerById(id);
        return ResponseEntity.ok(volunteer);
    }
    
    @PostMapping
    @Operation(summary = "Create new volunteer")
    public ResponseEntity<VolunteerProfile> createVolunteer(@RequestBody RegisterRequest request) {
        VolunteerProfile volunteer = volunteerProfileService.registerVolunteer(request);
        return ResponseEntity.ok(volunteer);
    }
    
    @PutMapping("/{id}/availability")
    @Operation(summary = "Update volunteer availability")
    public ResponseEntity<VolunteerProfile> updateAvailability(@PathVariable Long id, 
                                                              @RequestBody AvailabilityUpdateRequest request) {
        VolunteerProfile volunteer = volunteerProfileService.updateAvailability(id, request.getAvailabilityStatus());
        return ResponseEntity.ok(volunteer);
    }
}