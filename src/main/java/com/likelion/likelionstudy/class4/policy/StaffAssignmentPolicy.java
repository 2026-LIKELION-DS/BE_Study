package com.likelion.likelionstudy.class4.policy;

public class StaffAssignmentPolicy implements AssignmentPolicy {
    @Override
    public boolean canSubmit() {
        return false;
    }
}