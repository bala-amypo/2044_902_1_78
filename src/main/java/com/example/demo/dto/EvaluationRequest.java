package com.example.demo.dto;

public class EvaluationRequest {
    private Integer rating;
    private String feedback;

    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }

    public String getFeedback() { return feedback; }
    public void setFeedback(String feedback) { this.feedback = feedback; }
}