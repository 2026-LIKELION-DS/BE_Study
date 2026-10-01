package com.example.pbl_week6.assignment.dto;

public class AssignmentUpdateRequest {
    private String title;
    private String description;

    public AssignmentUpdateRequest() {}

    public AssignmentUpdateRequest(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
}