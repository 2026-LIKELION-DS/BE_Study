package class5.role;

import class5.policy.LionSubmissionPolicy;
import class5.policy.SubmissionPolicy;

/** 아기사자: 공통 속성 + 학번(studentId). 항상 과제 제출 대상. */
public class Lion extends Role {

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
        return "🦁 역할: " + getRoleName() + "\n"
                + "이름: " + getName() + " | 전공: " + getMajor()
                + " | 기수: " + getGeneration() + " | 파트: " + getPart() + "\n"
                + "    학번: " + studentId;
    }
}
