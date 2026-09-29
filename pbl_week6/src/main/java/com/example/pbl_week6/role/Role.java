package com.example.pbl_week6.role;

import com.example.pbl_week6.policy.SubmissionPolicy;

public abstract class Role {
    private String name;
    private String major;
    private int generation;
    private String part;
    private String studentId;
    private SubmissionPolicy submissionPolicy;

    public Role(String name, String major, int generation, String part, String studentId, SubmissionPolicy submissionPolicy) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.studentId = studentId;
        this.submissionPolicy = submissionPolicy;
    }

    public abstract String getRoleName();

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public int getGeneration() {
        return generation;
    }

    public String getPart() {
        return part;
    }

    public String getStudentId() {
        return studentId;
    }

    public SubmissionPolicy getSubmissionPolicy() {
        return submissionPolicy;
    }

    public boolean canSubmitAssignment() {
        return submissionPolicy != null && submissionPolicy.canSubmit();
    }
}