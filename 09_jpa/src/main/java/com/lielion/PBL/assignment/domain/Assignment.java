package com.lielion.PBL.assignment.domain;

import com.lielion.PBL.member.domain.Member;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    /** @ManyToOne : 여러 과제가 한 멤버에 속한다. @JoinColumn : 외래 키 컬럼 이름을 member_id 로 지정. */
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    // JPA 가 엔티티를 만들 때 필요한 기본 생성자 (외부에서는 못 쓰게 protected)
    protected Assignment() {
    }

    public Assignment(String title, String description, Member member) {
        this.title = title;
        this.description = description;
        this.member = member;
    }

    public void updateInfo(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public Member getMember() { return member; }
}
