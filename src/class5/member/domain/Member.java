package class5.member.domain;

import class5.assignment.domain.Assignment;
import jakarta.persistence.*;

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
    @Column(name = "role_type")
    private RoleType roleType;

    @Column(name = "student_id")
    private String studentId;
    private String position;

    @OneToMany(mappedBy = "member")
    private List<Assignment> assignments = new ArrayList<>();

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

    public void updateInfo(String major, int generation, String part) {
        this.major = major;
        this.generation = generation;
        this.part = part;
    }

    public void updateStudentId(String studentId) {
        this.studentId = studentId;
        this.position = null;
    }

    public void updatePosition(String position) {
        this.position = position;
        this.studentId = null;
    }

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
