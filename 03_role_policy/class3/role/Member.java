package class3.role;

import class3.policy.SubmissionPolicy;

//추상 클래스
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

    protected String getName() {
        return name;
    }

    protected String getMajor() {
        return major;
    }

    protected int getGeneration() {
        return generation;
    }

    protected String getPart() {
        return part;
    }

    //역할별로 다른 정책 객체를 반환 -> 하위 클래스가 각자 구현
    protected abstract SubmissionPolicy getPolicy();

    //역할별 상세 정보를 문자열로 반환 -> 하위 클래스가 각자 구현
    public abstract String getDetailInfo();

    public boolean canSubmit() {
        return getPolicy().isSubmittable();
    }
}
