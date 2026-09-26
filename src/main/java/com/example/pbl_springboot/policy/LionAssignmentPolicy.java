package com.example.pbl_springboot.policy;

public class LionAssignmentPolicy implements AssignmentPolicy {

    @Override
    public boolean canSubmit() {
        return true;
    }
}