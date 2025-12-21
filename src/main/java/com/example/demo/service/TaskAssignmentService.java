package com.example.demo.service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.model.TaskRecord;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.repository.TaskAssignmentRecordRepository;
import com.example.demo.repository.TaskRecordRepository;
import com.example.demo.repository.VolunteerProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskAssignmentService {

    private final TaskAssignmentRecordRepository assignRepo;
    private final TaskRecordRepository taskRepo;
    private final VolunteerProfileRepository volunteerRepo;

    public TaskAssignmentService(
            TaskAssignmentRecordRepository assignRepo,
            TaskRecordRepository taskRepo,
            VolunteerProfileRepository volunteerRepo) {
        this.assignRepo = assignRepo;
        this.taskRepo = taskRepo;
        this.volunteerRepo = volunteerRepo;
    }

    public TaskAssignmentRecord assign(Long taskId, Long volunteerId) {

        if (assignRepo.existsByTaskIdAndStatus(taskId, "ACTIVE")) {
            throw new BadRequestException("ACTIVE assignment");
        }

        TaskRecord task = taskRepo.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        VolunteerProfile volunteer = volunteerRepo.findById(volunteerId)
                .orElseThrow(() -> new ResourceNotFoundException("Volunteer not found"));

        if (!"AVAILABLE".equals(volunteer.getAvailabilityStatus())) {
            throw new BadRequestException("Volunteer not AVAILABLE");
        }

        TaskAssignmentRecord record = new TaskAssignmentRecord();
        record.setTaskId(taskId);
        record.setVolunteerId(volunteerId);

        return assignRepo.save(record);
    }
}