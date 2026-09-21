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

    // 정책 객체 반환
    public abstract SubmissionPolicy getPolicy();

    // 상세 정보 반환
    public abstract String getDetails();

    // 과제 제출 가능 여부 판단을 정책 객체에 위임
    public boolean canSubmit() {
        return getPolicy().canSubmit();
    }

    // Lion과 Staff가 공통으로 출력해야 하는 기본 정보 문자열을 만들어 주는 메서드
    public String getCommonInfo() {
        return String.format("👤 이름: %s | 🎓 전공: %s | 📌 기수: %d | 💻 파트: %s",
                name, major, generation, part);
    }
}