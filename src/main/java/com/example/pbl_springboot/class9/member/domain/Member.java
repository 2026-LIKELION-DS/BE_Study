package com.example.pbl_springboot.class9.member.domain;

import jakarta.persistence.*;
import com.example.pbl_springboot.class9.assignment.domain.Assignment;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
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

    public Member(
            String name,
            String major,
            int generation,
            String part,
            RoleType roleType,
            String studentId,
            String position
    ) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.roleType = roleType;
        this.studentId = studentId;
        this.position = position;
    }

    public void updateInfo(
            String major,
            int generation,
            String part
    ) {
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

    @OneToMany(mappedBy = "member")
    private List<Assignment> assignments = new ArrayList<>();

    public List<Assignment> getAssignments() {
        return assignments;
    }
}