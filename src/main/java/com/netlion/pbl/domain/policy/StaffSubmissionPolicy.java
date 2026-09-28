package com.netlion.pbl.domain.policy;

public class StaffSubmissionPolicy implements SubmissionPolicy {
    @Override
    public boolean canSubmit() {
        return false;
    }
}
