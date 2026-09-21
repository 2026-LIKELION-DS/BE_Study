package com.netlion.netflix.week4.class4.role;

import com.netlion.netflix.week4.class4.policy.SubmissionPolicy;

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

    public String getPart() {
        return part;
    }

    protected String getMajor() {
        return major;
    }

    protected int getGeneration() {
        return generation;
    }

    protected abstract SubmissionPolicy getPolicy();

    public abstract String getRoleName();

    public abstract String getDetailInfo();

    public boolean canSubmit() {
        return getPolicy().canSubmit();
    }

    public String getSummary() {
        return "[" + getRoleName() + "] " + name + " - " + generation + "기";
    }
}
