package com.example.demo.controller;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.service.VolunteerSkillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class VolunteerSkillController {

    private final VolunteerSkillService service;

    public VolunteerSkillController(VolunteerSkillService service) {
        this.service = service;
    }

    // POST
    @PostMapping
    public VolunteerSkillRecord create(@RequestBody VolunteerSkillRecord skill) {
        return service.create(skill);
    }

    // GET ALL
    @GetMapping
    public List<VolunteerSkillRecord> getAll() {
        return service.getAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public VolunteerSkillRecord getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // PUT
    @PutMapping("/{id}")
    public VolunteerSkillRecord update(
            @PathVariable Long id,
            @RequestBody VolunteerSkillRecord skill) {
        return service.update(id, skill);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
