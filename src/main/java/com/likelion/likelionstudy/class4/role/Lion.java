package com.likelion.likelionstudy.class4.role;

import com.likelion.likelionstudy.class4.policy.AssignmentPolicy;
import com.likelion.likelionstudy.class4.policy.LionAssignmentPolicy;

public class Lion extends User {
    private String studentId;

    public Lion(String name, String major, int generation, String part, String studentId) {
        super(name, major, generation, part);
        this.studentId = studentId;
    }

    @Override
    public AssignmentPolicy getAssignmentPolicy() {
        return new LionAssignmentPolicy();
    }

    @Override
    public String getRoleName() {
        return "아기사자";
    }

    @Override
    public String getDetailInfo() {
        return "학번: " + studentId;
    }
}