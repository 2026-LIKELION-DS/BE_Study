package com.likelion.likelionstudy.class5.role;

import com.likelion.likelionstudy.class5.policy.LionSubmissionPolicy;
import com.likelion.likelionstudy.class5.policy.SubmissionPolicy;

public class Lion extends Role {
    private String studentId;

    public Lion(String name, String major, int generation, String part, String studentId) {
        super(name, major, generation, part);
        this.studentId = studentId;
    }

    @Override
    public SubmissionPolicy getSubmissionPolicy() {
        return new LionSubmissionPolicy();
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