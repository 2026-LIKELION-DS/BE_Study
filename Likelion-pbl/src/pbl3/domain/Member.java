package pbl3.domain;

import pbl3.policy.SubmissionPolicy;

public abstract class Member {
    private String name;
    private String major;
    private int generation;
    private String part;

    public Member(String name, String major, int generation, String part) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
    }

    // 추상 메서드: 하위 클래스가 자신의 정책 객체와 상세 정보를 반환하도록 강제
    public abstract SubmissionPolicy getSubmissionPolicy();
    public abstract String getRoleSpecificInfo();

    // 공통 동작: 과제 제출 가능 여부 판단을 정책 객체에 위임(Delegation)
    public boolean canSubmitAssignment() {
        return getSubmissionPolicy().canSubmitAssignment();
    }

    public String getName() { return name; }
    public String getMajor() { return major; }
    public int getGeneration() { return generation; }
    public String getPart() { return part; }
}