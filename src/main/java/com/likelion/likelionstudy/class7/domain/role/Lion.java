package com.likelion.likelionstudy.class7.domain.role;

public class Lion extends Role {
    private String studentId;

    public Lion(String name, String major, int generation, String part, String studentId) {
        super(name, major, generation, part);
        this.studentId = studentId;
    }

    public String getStudentId() { return studentId; }

    @Override
    public String getRoleName() {
        return "아기사자";
    }

    public void updateLionInfo(String major, int generation, String part, String studentId) {
        super.updateCommonInfo(major, generation, part);
        this.studentId = studentId;
    }
}