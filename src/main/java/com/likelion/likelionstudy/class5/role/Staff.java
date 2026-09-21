package com.likelion.likelionstudy.class5.role;

import com.likelion.likelionstudy.class5.policy.StaffSubmissionPolicy;
import com.likelion.likelionstudy.class5.policy.SubmissionPolicy;

public class Staff extends Role {
    private String position;

    public Staff(String name, String major, int generation, String part, String position) {
        super(name, major, generation, part);
        this.position = position;
    }

    @Override
    public SubmissionPolicy getSubmissionPolicy() {
        return new StaffSubmissionPolicy();
    }

    @Override
    public String getRoleName() {
        return "운영진";
    }

    @Override
    public String getDetailInfo() {
        return "직책: " + position;
    }
}