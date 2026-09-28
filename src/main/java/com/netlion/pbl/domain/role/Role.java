package com.netlion.pbl.domain.role;

import com.netlion.pbl.domain.policy.SubmissionPolicy;

public abstract class Role {
    private String name;
    private String major;
    private int generation;
    private String part;

    public Role(String name, String major, int generation, String part) {
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

    protected abstract SubmissionPolicy getPolicy();

    public abstract String getRoleName();

    public boolean canSubmit() {
        return getPolicy().canSubmit();
    }
}
