package class3.role;

import class3.policy.StaffSubmissionPolicy;
import class3.policy.SubmissionPolicy;

public class Staff extends Member {
    private String position;
    private final SubmissionPolicy policy = new StaffSubmissionPolicy();

    public Staff(String name, String major, int generation, String part, String position) {
        super(name, major, generation, part);
        this.position = position;
    }

    @Override
    public SubmissionPolicy getPolicy() {
        return this.policy;
    }

    @Override
    public String getDetails() {
        return "🤗 역할: 운영진\n" +
                getCommonInfo() + "\n" +
                "⭐ 직책: " + position;
    }
}