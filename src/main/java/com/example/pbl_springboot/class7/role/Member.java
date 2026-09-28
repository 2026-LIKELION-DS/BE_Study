package com.example.pbl_springboot.class7.role;

import com.example.pbl_springboot.class7.policy.AssignmentPolicy;

public abstract class Member {

    private String name;
    private String major;
    private int generation;
    private String part;

    public Member(String name, String major, int generation, String part) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
    }

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

    public abstract String getRoleName();

    protected abstract AssignmentPolicy getAssignmentPolicy();

    public abstract String getDetailInfo();

    public boolean canSubmitAssignment() {
        return getAssignmentPolicy().canSubmit();
    }

    public String getSubmitResult() {
        return canSubmitAssignment() ? "✅ 가능" : "❌ 불가능";
    }
}