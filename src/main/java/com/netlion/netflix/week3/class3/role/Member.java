package com.netlion.netflix.week3.class3.role;

import com.netlion.netflix.week3.class3.policy.SubmissionPolicy;

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

    protected String getName() {
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

    protected abstract String getRoleName();

    public abstract String getDetailInfo();

    public boolean canSubmit() {
        return getPolicy().canSubmit();
    }

    public void printInfo() {
        System.out.println("역할: " + getRoleName());
        System.out.println(getDetailInfo());
        String result = canSubmit() ? "가능" : "불가능";
        System.out.println("과제 제출 가능 여부: " + result);
        System.out.println("--------------------------");
    }
}
