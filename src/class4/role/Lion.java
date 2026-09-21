package class4.role;

import class4.policy.LionSubmissionPolicy;

public class Lion extends Role {

    public Lion(String name, String major, int generation, String part, String studentId) {
        // 아기사자는 과제 제출 가능 정책(LionSubmissionPolicy)을 주입받음
        super(name, major, generation, part, studentId, new LionSubmissionPolicy());
    }

    @Override
    public String getRoleName() {
        return "아기사자";
    }
}