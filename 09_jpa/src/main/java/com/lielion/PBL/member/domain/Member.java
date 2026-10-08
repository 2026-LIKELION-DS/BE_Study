package com.lielion.PBL.member.domain;

import java.util.ArrayList;
import java.util.List;

import com.lielion.PBL.assignment.domain.Assignment;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Member {

    /** 기본키. IDENTITY = DB(MySQL의 AUTO_INCREMENT)가 id 를 만들어 준다. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String major;
    private int generation;
    private String part;

    /** STRING = 숫자(0, 1)가 아니라 "LION", "STAFF" 문자열로 저장한다 (Enum 순서가 바뀌어도 안전). */
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    private String studentId; // Lion 일 때만 값이 있음
    private String position;  // Staff 일 때만 값이 있음

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Assignment> assignments = new ArrayList<>();

    /** JPA 가 엔티티 객체를 만들 때 필요한 기본 생성자 (외부에서는 못 쓰게 protected). */
    protected Member() {
    }

    public Member(String name, String major, int generation, String part,
                  RoleType roleType, String studentId, String position) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.roleType = roleType;
        this.studentId = studentId;
        this.position = position;
    }

    // ----- 수정용 메서드 -----
    public void updateInfo(String major, int generation, String part) {
        this.major = major;
        this.generation = generation;
        this.part = part;
    }

    public void updateStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void updatePosition(String position) {
        this.position = position;
    }

    // ----- Getter -----
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getMajor() { return major; }
    public int getGeneration() { return generation; }
    public String getPart() { return part; }
    public RoleType getRoleType() { return roleType; }
    public String getStudentId() { return studentId; }
    public String getPosition() { return position; }
    public List<Assignment> getAssignments() { return assignments; }
}
