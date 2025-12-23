package com.example.demo.controller;

import com.example.demo.model.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/volunteers")
public class VolunteerProfileController {

    private final VolunteerProfileService service;

    public VolunteerProfileController(VolunteerProfileService service) {
        this.service = service;
    }

    @PostMapping
    public VolunteerProfile create(@RequestBody VolunteerProfile v) {
        return service.save(v);
    }

    @GetMapping
    public List<VolunteerProfile> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public VolunteerProfile getById(@PathVariable Long id) {
        return service.getById(id);
    }
}
