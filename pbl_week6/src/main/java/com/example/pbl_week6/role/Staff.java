package com.example.pbl_week6.role;

import com.example.pbl_week6.policy.StaffSubmissionPolicy;

public class Staff extends Role {
    private String position;

    public Staff(String name, String major, int generation, String part, String position) {
        // 부모(Role)의 studentId 자리에는 빈 문자열 전달
        super(name, major, generation, part, "", new StaffSubmissionPolicy());
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String getRoleName() {
        return "운영진";
    }
}