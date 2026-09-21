package com.likelion.likelionstudy.class4.role;

import com.likelion.likelionstudy.class4.policy.AssignmentPolicy;

public abstract class User {
    private String name;
    private String major;
    private int generation;
    private String part;

    public User(String name, String major, int generation, String part) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
    }

    public String getName() { return name; }
    public String getMajor() { return major; }
    public int getGeneration() { return generation; }
    public String getPart() { return part; }

    public abstract AssignmentPolicy getAssignmentPolicy();
    public abstract String getRoleName();
    public abstract String getDetailInfo();

    public boolean canSubmitAssignment() {
        return getAssignmentPolicy().canSubmit();
    }
}