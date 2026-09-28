package com.likelion.likelionstudy.class7.domain.role;

public class Staff extends Role {
    private String position;

    public Staff(String name, String major, int generation, String part, String position) {
        super(name, major, generation, part);
        this.position = position;
    }

    public String getPosition() { return position; }

    @Override
    public String getRoleName() {
        return "운영진";
    }

    public void updateStaffInfo(String major, int generation, String part, String position) {
        super.updateCommonInfo(major, generation, part);
        this.position = position;
    }
}