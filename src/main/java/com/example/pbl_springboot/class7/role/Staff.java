package com.example.pbl_springboot.class7.role;

import com.example.pbl_springboot.class7.policy.AssignmentPolicy;
import com.example.pbl_springboot.class7.policy.StaffAssignmentPolicy;

public class Staff extends Member {

    private String position;

    public Staff(String name, String major, int generation,
                 String part, String position) {

        super(name, major, generation, part);
        this.position = position;
    }

    @Override
    public String getRoleName() {
        return "운영진";
    }

    @Override
    protected AssignmentPolicy getAssignmentPolicy() {
        return new StaffAssignmentPolicy();
    }

    @Override
    public String getDetailInfo() {
        return "🎭 역할: 운영진\n"
                + "👤 이름: " + getName()
                + " | 🎓 전공: " + getMajor()
                + " | 📌 기수: " + getGeneration()
                + " | 💻 파트: " + getPart() + "\n"
                + "⭐ 직책: " + position;
    }

    public String getPosition() {
        return position;
    }
}