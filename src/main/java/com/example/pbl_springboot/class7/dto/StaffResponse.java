package com.example.pbl_springboot.class7.dto;

import com.example.pbl_springboot.class7.role.Staff;

public class StaffResponse {

    private final String name;
    private final String major;
    private final int generation;
    private final String part;
    private final String roleName;
    private final String position;

    public StaffResponse(
            String name,
            String major,
            int generation,
            String part,
            String roleName,
            String position
    ) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.roleName = roleName;
        this.position = position;
    }

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

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public int getGeneration() {
        return generation;
    }

    public String getPart() {
        return part;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getPosition() {
        return position;
    }
}