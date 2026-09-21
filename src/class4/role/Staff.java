package class4.role;

import class4.policy.StaffSubmissionPolicy;

public class Staff extends Role {

    public Staff(String name, String major, int generation, String part, String studentId) {
        // 운영진은 과제 제출 불가 정책(StaffSubmissionPolicy)을 주입받음
        super(name, major, generation, part, studentId, new StaffSubmissionPolicy());
    }

    @Override
    public String getRoleName() {
        return "운영진";
    }
}