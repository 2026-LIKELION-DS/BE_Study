package com.example.pbl_springboot.class7.policy;

public class StaffAssignmentPolicy implements AssignmentPolicy {

    @Override
    public boolean canSubmit() {
        return false;
    }
}