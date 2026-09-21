package pbl3.domain;

import pbl3.policy.StaffSubmissionPolicy;
import pbl3.policy.SubmissionPolicy;

public class Staff extends Member {
    private String roleTitle; // 운영진 전용 속성: 직책 (예: 대표, 파트장 등)

    public Staff(String name, String major, int generation, String part, String roleTitle) {
        super(name, major, generation, part);
        this.roleTitle = roleTitle;
    }

    @Override
    public SubmissionPolicy getSubmissionPolicy() {
        return new StaffSubmissionPolicy();
    }

    @Override
    public String getRoleSpecificInfo() {
        return "직책: " + roleTitle;
    }
}