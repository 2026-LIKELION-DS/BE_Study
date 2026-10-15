package com.likelion.likelionstudy.class8.domain;

import com.likelion.likelionstudy.assignment.domain.Assignment;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String studentId;
    private String major;
    private int generation;
    private String part;
    private String position;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @OneToMany(mappedBy = "member")
    private List<Assignment> assignments = new ArrayList<>();

    public Member(String name, String studentId, String major, int generation, String part) {
        this.name = name;
        this.studentId = studentId;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.roleType = RoleType.LION;
    }

    public Member(String name, String studentId, String major, int generation, String part, String position) {
        this.name = name;
        this.studentId = studentId;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.position = position;
        this.roleType = RoleType.STAFF;
    }


    public void updateLion(String name, String studentId, String major, int generation, String part) {
        this.name = name;
        this.studentId = studentId;
        this.major = major;
        this.generation = generation;
        this.part = part;
    }

    public void updateStaff(String name, String studentId, String major, int generation, String part, String position) {
        this.name = name;
        this.studentId = studentId;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.position = position;
    }
}