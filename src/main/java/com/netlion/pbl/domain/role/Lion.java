package com.netlion.pbl.domain.role;

import com.netlion.pbl.domain.policy.LionSubmissionPolicy;
import com.netlion.pbl.domain.policy.SubmissionPolicy;

public class Lion extends Role {
    private String studentId;

    public Lion(String name, String major, int generation, String part, String studentId) {
        super(name, major, generation, part);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    @Override
    protected SubmissionPolicy getPolicy() {
        return new LionSubmissionPolicy();
    }

    @Override
    public String getRoleName() {
        return "아기사자";
    }
}
