package class3.role;

import class3.policy.SubmissionPolicy;
import class3.policy.LionSubmissionPolicy;

public class Lion extends Member {
    private String studentId;

    public Lion(String name, String major, int generation, String part, String studentId) {
        super(name, major, generation, part);
        this.studentId = studentId;
    }

    @Override
    protected SubmissionPolicy getPolicy() {
        return new LionSubmissionPolicy();
    }

    @Override
    public String getRoleName() {
        return "아기사자";
    }

    @Override
    public String getDetailInfo() {
        return "🆔 학번: " + studentId;
    }
}