package com.netlion.pbl.member.domain;

import jakarta.persistence.*;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String major;
    private int generation;
    private String part;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    private String studentId;
    private String position;

    protected Member() {
    }

    public static Member createLion(String name, String major, int generation, String part, String studentId) {
        Member member = new Member();
        member.name = name;
        member.major = major;
        member.generation = generation;
        member.part = part;
        member.roleType = RoleType.LION;
        member.studentId = studentId;
        return member;
    }

    public static Member createStaff(String name, String major, int generation, String part, String position) {
        Member member = new Member();
        member.name = name;
        member.major = major;
        member.generation = generation;
        member.part = part;
        member.roleType = RoleType.STAFF;
        member.position = position;
        return member;
    }

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
    
    public Long getId() {
        return id;
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

    public RoleType getRoleType() {
        return roleType;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getPosition() {
        return position;
    }
}
