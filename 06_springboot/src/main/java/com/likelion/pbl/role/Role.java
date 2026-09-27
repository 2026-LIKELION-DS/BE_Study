package com.likelion.pbl.role;

import com.likelion.pbl.policy.SubmissionPolicy;

/**
 * 멋쟁이사자처럼 활동 구성원을 표현하는 추상 클래스 (3~5주차와 동일한 역할).
 *
 * 필드는 모두 private으로 유지한다.
 * (7주차부터 major도 DTO 변환(dto 패키지)에서 읽어야 해서 public getter로 노출한다.
 *  3~6주차에선 role 패키지 내부에서만 쓰라고 protected였는데, REST API 응답을 만들려면
 *  컨트롤러/DTO 계층에서도 이 값을 꺼내야 하므로 이번 주차에 public으로 풀었다.)
 */
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

    public String getMajor() {
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
