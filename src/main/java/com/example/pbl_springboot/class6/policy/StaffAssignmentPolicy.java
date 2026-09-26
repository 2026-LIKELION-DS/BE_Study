package com.example.pbl_springboot.class6.policy;

import com.example.pbl_springboot.class7.policy.AssignmentPolicy;

public class StaffAssignmentPolicy implements AssignmentPolicy {

    @Override
    public boolean canSubmit() {
        return false;
    }
}