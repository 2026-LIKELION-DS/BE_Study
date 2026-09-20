package class5.role;

import class5.policy.SubmissionPolicy;

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

    public String getName() {
        return name;
    }

    protected String getMajor() {
        return major;
    }

    public int getGeneration() {
        return generation;
    }

    public String getPart() {
        return part;
    }

    /** 역할별로 다른 정책 객체를 반환한다 (하위 클래스가 각자 구현). */
    protected abstract SubmissionPolicy getPolicy();

    /** 목록 출력 등에 쓰이는 역할 이름 ("아기사자" / "운영진"). */
    public abstract String getRoleName();

    /** 검색 결과 등에 쓰이는 상세 정보 문자열 (하위 클래스가 각자 구현). */
    public abstract String getDetailInfo();

    /**
     * 과제 제출 가능 여부. if/else, instanceof로 역할을 구분하지 않고
     * 정책 객체(getPolicy())에게 그대로 위임한다 (다형성).
     */
    public boolean canSubmit() {
        return getPolicy().isSubmittable();
    }
}
