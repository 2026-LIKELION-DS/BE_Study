package class4.role;

import class4.policy.SubmissionPolicy;

public abstract class Role {
    private String name;
    private String major;
    private int generation;
    private String part;

    public Role(String name, String major, int generation, String part) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
    }

    protected abstract SubmissionPolicy getPolicy();

    public abstract String getRoleName();

    public abstract String getDetailInfo();

    public String getCommonInfo() {
        return "👤 이름: " + this.name + " | 🚩 전공: " + this.major + " | 📌 기수: " + this.generation + " | 💻 파트: " + this.part;
    }

    public boolean canSubmitAssignment() {
        return this.getPolicy().canSubmit();
    }

    public String getName() {
        return this.name;
    }

    public int getGeneration() {
        return this.generation;
    }
}