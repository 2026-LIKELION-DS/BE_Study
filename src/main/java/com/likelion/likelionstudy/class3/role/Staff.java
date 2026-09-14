package com.likelion.likelionstudy.class3.role;

import com.likelion.likelionstudy.class3.policy.AssignmentPolicy;
import com.likelion.likelionstudy.class3.policy.StaffAssignmentPolicy;

public class Staff extends User {
    private String position;

    public Staff(String name, String major, int generation, String part, String position) {
        super(name, major, generation, part);
        this.position = position;
    }

    @Override
    public AssignmentPolicy getAssignmentPolicy() {
        return new StaffAssignmentPolicy();
    }

    @Override
    public String getRoleName() {
        return "운영진";
    }

    @Override
    public String getDetailInfo() {
        return "⭐ 직책: " + position;
    }
}