package com.example.demo.controller;

import com.example.demo.model.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/volunteers")
public class VolunteerProfileController {

    private final VolunteerProfileService service;

    public VolunteerProfileController(VolunteerProfileService service) {
        this.service = service;
    }

    @PostMapping
    public VolunteerProfile create(@RequestBody VolunteerProfile volunteer) {
        return service.create(volunteer);
    }

    @GetMapping
    public List<VolunteerProfile> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public VolunteerProfile getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public VolunteerProfile update(@PathVariable Long id,
                                   @RequestBody VolunteerProfile volunteer) {
        return service.update(id, volunteer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
