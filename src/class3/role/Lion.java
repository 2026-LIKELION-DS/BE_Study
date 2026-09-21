package class3.role;

import class3.policy.LionSubmissionPolicy;
import class3.policy.SubmissionPolicy;

public class Lion extends Member {
    private String studentId;
    private final SubmissionPolicy policy = new LionSubmissionPolicy();

    public Lion(String name, String major, int generation, String part, String studentId) {
        super(name, major, generation, part);
        this.studentId = studentId;
    }

    @Override
    public SubmissionPolicy getPolicy() {
        return this.policy;
    }

    @Override
    public String getDetails() {
        return "🤗 역할: 아기사자\n" +
                getCommonInfo() + "\n" +
                "🆔 학번: " + studentId;
    }
}