package com.example.pbl_springboot.class7.policy;

public class LionAssignmentPolicy implements AssignmentPolicy {

    @Override
    public boolean canSubmit() {
        return true;
    }
}