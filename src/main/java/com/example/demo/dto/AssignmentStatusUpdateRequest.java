package com.example.demo.dto;

public class AssignmentStatusUpdateRequest {
    private String status;

    public AssignmentStatusUpdateRequest() {}

    public AssignmentStatusUpdateRequest(String status) {
        this.status = status;
    }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}