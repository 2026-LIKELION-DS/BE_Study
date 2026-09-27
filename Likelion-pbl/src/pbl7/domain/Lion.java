package pbl7.domain;

public class Lion extends Member {
    private String studentId;

    public Lion(String name, String major, int generation, String part, String studentId) {
        super(name, major, generation, part);
        this.studentId = studentId;
    }

    @Override
    public String getRoleName() {
        return "아기사자";
    }

    public String getStudentId() { return studentId; }

    public void updateLionInfo(String major, int generation, String part, String studentId) {
        updateCommonInfo(major, generation, part);
        this.studentId = studentId;
    }
}