package com.netlion.netflix.week5.class5.role;

import com.netlion.netflix.week5.class5.policy.SubmissionPolicy;

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

    protected String getMajor() {
        return major;
    }

    protected int getGeneration() {
        return generation;
    }

    protected String getPart() {
        return part;
    }

    protected abstract SubmissionPolicy getPolicy();

    public abstract String getRoleName();

    public abstract String getDetailInfo();

    public boolean canSubmit() {
        return getPolicy().canSubmit();
    }
}
