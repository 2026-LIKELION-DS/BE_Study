package com.likelion.pbl.dto;

import com.likelion.pbl.role.Staff;

/** Staff 응답 DTO. */
public record StaffResponse(
        String name,
        String major,
        int generation,
        String part,
        String roleName,
        String position
) {

    public static StaffResponse from(Staff staff) {
        return new StaffResponse(
                staff.getName(),
                staff.getMajor(),
                staff.getGeneration(),
                staff.getPart(),
                staff.getRoleName(),
                staff.getPosition()
        );
    }
}
