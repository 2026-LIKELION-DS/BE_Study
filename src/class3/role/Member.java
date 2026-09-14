package class3.role;

import class3.policy.SubmissionPolicy;

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

    // 역할별로 다른 정책 객체를 반환 (다형성의 핵심)
    protected abstract SubmissionPolicy getPolicy();

    // 역할 이름표 (예: "아기사자", "운영진")
    public abstract String getRoleName();

    // 역할별 추가 정보 (학번 / 직책)를 문자열로 반환
    public abstract String getDetailInfo();

    // 공통 정보 출력 문자열 (private 필드는 여기서만 다룸)
    public String getCommonInfo() {
        return "👤 이름: " + name + " | 🚩 전공: " + major
                + " | 📌 기수: " + generation + " | 💻 파트: " + part;
    }

    // 제출 가능 여부 판단은 정책 객체에 위임
    public boolean canSubmitAssignment() {
        return getPolicy().canSubmit();
    }
}