package com.netlion.netflix.week5.class5.policy;

public class StaffSubmissionPolicy implements SubmissionPolicy {
    @Override
    public boolean canSubmit() {
        return false;
    }
}
