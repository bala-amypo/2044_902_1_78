package com.example.demo.dto;

public class AvailabilityUpdateRequest {
    private String availabilityStatus;

    public AvailabilityUpdateRequest() {}

    public AvailabilityUpdateRequest(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public String getAvailabilityStatus() { return availabilityStatus; }
    public void setAvailabilityStatus(String availabilityStatus) { this.availabilityStatus = availabilityStatus; }
}