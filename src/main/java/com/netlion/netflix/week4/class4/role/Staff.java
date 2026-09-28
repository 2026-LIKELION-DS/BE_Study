package com.netlion.netflix.week4.class4.role;

import com.netlion.netflix.week4.class4.policy.StaffSubmissionPolicy;
import com.netlion.netflix.week4.class4.policy.SubmissionPolicy;

public class Staff extends Role {
    private String position;

    public Staff(String name, String major, int generation, String part, String position) {
        super(name, major, generation, part);
        this.position = position;
    }

    @Override
    protected SubmissionPolicy getPolicy() {
        return new StaffSubmissionPolicy();
    }

    @Override
    public String getRoleName() {
        return "운영진";
    }

    @Override
    public String getDetailInfo() {
        return "이름: " + getName() + " | 전공: " + getMajor()
                + " | 기수: " + getGeneration() + " | 파트: " + getPart()
                + " | 직책: " + position;
    }
}
