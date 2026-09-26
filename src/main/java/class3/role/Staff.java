package class3.role;

import class3.policy.AssignmentPolicy;
import class3.policy.StaffAssignmentPolicy;

public class Staff extends Member {

    private String position;

    public Staff(String name, String major, int generation,
                 String part, String position) {

        super(name, major, generation, part);
        this.position = position;
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
}