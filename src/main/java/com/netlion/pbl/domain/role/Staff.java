package com.netlion.pbl.domain.role;

import com.netlion.pbl.domain.policy.StaffSubmissionPolicy;
import com.netlion.pbl.domain.policy.SubmissionPolicy;

public class Staff extends Role {
    private String position;

    public Staff(String name, String major, int generation, String part, String position) {
        super(name, major, generation, part);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    @Override
    protected SubmissionPolicy getPolicy() {
        return new StaffSubmissionPolicy();
    }

    @Override
    public String getRoleName() {
        return "운영진";
    }
}
