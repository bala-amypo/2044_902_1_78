package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.TaskRecord;
import com.example.demo.repository.TaskRecordRepository;
import com.example.demo.service.TaskRecordService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskRecordServiceImpl implements TaskRecordService {
    
    private final TaskRecordRepository taskRecordRepository;
    
    public TaskRecordServiceImpl(TaskRecordRepository taskRecordRepository) {
        this.taskRecordRepository = taskRecordRepository;
    }
    
    @Override
    public TaskRecord createTask(TaskRecord task) {
        if (task.getStartDate() != null && task.getEndDate() != null && 
            task.getStartDate().isAfter(task.getEndDate())) {
            throw new BadRequestException("Start date cannot be after end date");
        }
        
        task.setStatus("OPEN");
        return taskRecordRepository.save(task);
    }
    
    @Override
    public TaskRecord updateTask(Long id, TaskRecord task) {
        TaskRecord existing = taskRecordRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Task not found"));
        
        existing.setTaskName(task.getTaskName());
        existing.setDescription(task.getDescription());
        existing.setRequiredSkill(task.getRequiredSkill());
        existing.setRequiredSkillLevel(task.getRequiredSkillLevel());
        existing.setPriority(task.getPriority());
        existing.setStatus(task.getStatus());
        existing.setStartDate(task.getStartDate());
        existing.setEndDate(task.getEndDate());
        
        return taskRecordRepository.save(existing);
    }
    
    @Override
    public TaskRecord getTaskById(Long id) {
        return taskRecordRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Task not found"));
    }
    
    @Override
    public List<TaskRecord> getOpenTasks() {
        return taskRecordRepository.findByStatus("OPEN");
    }
    
    @Override
    public List<TaskRecord> getAllTasks() {
        return taskRecordRepository.findAll();
    }
    
    @Override
    public Optional<TaskRecord> getTaskByCode(String taskCode) {
        return taskRecordRepository.findByTaskCode(taskCode);
    }
}