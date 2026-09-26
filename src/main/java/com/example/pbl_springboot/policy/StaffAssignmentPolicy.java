package com.example.pbl_springboot.policy;

public class StaffAssignmentPolicy implements AssignmentPolicy {

    @Override
    public boolean canSubmit() {
        return false;
    }
}