package class5.role;

import class5.policy.StaffSubmissionPolicy;
import class5.policy.SubmissionPolicy;

public class Staff extends Role {
    private String position;

    public Staff(String name, String major, int generation, String part, String position) {
        super(name, major, generation, part);
        this.position = position;
    }

    protected SubmissionPolicy getPolicy() {
        return new StaffSubmissionPolicy();
    }

    public String getRoleName() {
        return "운영진";
    }

    public String getDetailInfo() {
        return "⭐ 직책: " + this.position;
    }
}