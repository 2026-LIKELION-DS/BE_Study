package class3.role;

import class3.policy.AssignmentPolicy;
import class3.policy.LionAssignmentPolicy;

public class Lion extends Member {

    private String studentId;

    public Lion(String name, String major, int generation, String part, String studentId) {
        super(name, major, generation, part);
        this.studentId = studentId;
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
}