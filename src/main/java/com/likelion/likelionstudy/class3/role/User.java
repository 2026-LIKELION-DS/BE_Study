package com.likelion.likelionstudy.class3.role;

import com.likelion.likelionstudy.class3.policy.AssignmentPolicy;

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

    // 다형성을 위한 추상 메서드
    public abstract AssignmentPolicy getAssignmentPolicy();
    public abstract String getRoleName();
    public abstract String getDetailInfo();

    // 제출 가능 여부 판단 위임
    public boolean canSubmitAssignment() {
        return getAssignmentPolicy().canSubmit();
    }
}