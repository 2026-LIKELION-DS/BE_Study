package com.example.pbl_springboot.class7.role;

import com.example.pbl_springboot.class7.policy.AssignmentPolicy;
import com.example.pbl_springboot.class7.policy.LionAssignmentPolicy;

public class Lion extends Member {

    private String studentId;

    public Lion(String name, String major, int generation, String part, String studentId) {
        super(name, major, generation, part);
        this.studentId = studentId;
    }

    @Override
    public String getRoleName() {
        return "아기사자";
    }

    @Override
    protected AssignmentPolicy getAssignmentPolicy() {
        return new LionAssignmentPolicy();
    }

    @Override
    public String getDetailInfo() {
        return "🦁 역할: 아기사자\n"
                + "👤 이름: " + getName()
                + " | 🎓 전공: " + getMajor()
                + " | 📌 기수: " + getGeneration()
                + " | 💻 파트: " + getPart() + "\n"
                + "🆔 학번: " + studentId;
    }

    public String getStudentId() {
        return studentId;
    }
}