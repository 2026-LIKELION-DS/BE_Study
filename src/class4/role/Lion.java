package class4.role;

import class4.policy.LionSubmissionPolicy;
import class4.policy.SubmissionPolicy;

public class Lion extends Role {
    private String studentId;

    public Lion(String name, String major, int generation, String part, String studentId) {
        super(name, major, generation, part);
        this.studentId = studentId;
    }

    protected SubmissionPolicy getPolicy() {
        return new LionSubmissionPolicy();
    }

    public String getRoleName() {
        return "아기사자";
    }

    public String getDetailInfo() {
        return "🆔 학번: " + this.studentId;
    }
}