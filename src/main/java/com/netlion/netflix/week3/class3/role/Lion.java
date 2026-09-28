package com.netlion.netflix.week3.class3.role;

import com.netlion.netflix.week3.class3.policy.LionSubmissionPolicy;
import com.netlion.netflix.week3.class3.policy.SubmissionPolicy;

public class Lion extends Member {
    private String studentId;

    public Lion(String name, String major, int generation, String part, String studentId) {
        super(name, major, generation, part);
        this.studentId = studentId;
    }

    @Override
    protected SubmissionPolicy getPolicy() {
        return new LionSubmissionPolicy();
    }

    @Override
    protected String getRoleName() {
        return "아기사자";
    }

    @Override
    public String getDetailInfo() {
        return "이름: " + getName() + " | 전공: " + getMajor()
                + " | 기수: " + getGeneration() + " | 파트: " + getPart() + "\n"
                + "학번: " + studentId;
    }
}
