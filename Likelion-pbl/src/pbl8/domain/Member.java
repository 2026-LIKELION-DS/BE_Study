package pbl8.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String major;
    private int generation;
    private String part;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleType roleType;

    private String studentId; // Lion 전용
    private String position;  // Staff 전용

    protected Member() {} // JPA 필수 기본 생성자

    public Member(String name, String major, int generation, String part, RoleType roleType, String studentId, String position) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.roleType = roleType;
        this.studentId = studentId;
        this.position = position;
    }

    // 수정 메서드
    public void updateLionInfo(String major, int generation, String part, String studentId) {
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.studentId = studentId;
    }

    public void updateStaffInfo(String major, int generation, String part, String position) {
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.position = position;
    }

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getMajor() { return major; }
    public int getGeneration() { return generation; }
    public String getPart() { return part; }
    public RoleType getRoleType() { return roleType; }
    public String getStudentId() { return studentId; }
    public String getPosition() { return position; }
}