package class3.role;

import class3.policy.SubmissionPolicy;
import class3.policy.StaffSubmissionPolicy;

public class Staff extends Member {
    private String position;

    public Staff(String name, String major, int generation, String part, String position) {
        super(name, major, generation, part);
        this.position = position;
    }

    @Override
    protected SubmissionPolicy getPolicy() {
        return new StaffSubmissionPolicy();
    }

    @Override
    public String getRoleName() {
        return "운영진";
    }

    @Override
    public String getDetailInfo() {
        return "⭐ 직책: " + position;
    }
}