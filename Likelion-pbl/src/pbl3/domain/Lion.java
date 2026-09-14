package pbl3.domain;

import pbl3.policy.LionSubmissionPolicy;
import pbl3.policy.SubmissionPolicy;

public class Lion extends Member {
    private String studentId; // 아기사자 전용 속성: 학번

    public Lion(String name, String major, int generation, String part, String studentId) {
        super(name, major, generation, part);
        this.studentId = studentId;
    }

    @Override
    public SubmissionPolicy getSubmissionPolicy() {
        return new LionSubmissionPolicy();
    }

    @Override
    public String getRoleSpecificInfo() {
        return "학번: " + studentId;
    }
}