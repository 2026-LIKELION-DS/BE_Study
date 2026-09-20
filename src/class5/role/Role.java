package class5.role;

import class4.policy.SubmissionPolicy;

public abstract class Role {
    private String name;
    private String major;
    private int generation;
    private String part;
    private String studentId;
    protected SubmissionPolicy policy; // 다형성을 위한 정책 인터페이스

    public Role(String name, String major, int generation, String part, String studentId, SubmissionPolicy policy) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.studentId = studentId;
        this.policy = policy;
    }

    // 역할명 반환 (자식 클래스에서 "아기사자" 또는 "운영진" 반환)
    public abstract String getRoleName();

    // 과제 제출 가능 여부 (주입된 Policy에 위임)
    public boolean canSubmitAssignment() {
        if (this.policy == null) {
            return false;
        }
        return this.policy.canSubmit();
    }

    // Getter 메서드
    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public int getGeneration() {
        return generation;
    }

    public String getPart() {
        return part;
    }

    public String getStudentId() {
        return studentId;
    }
}