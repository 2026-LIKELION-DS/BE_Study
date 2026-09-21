package pbl4.domain;

public class Lion extends Member {
    private String studentId;

    public Lion(String name, String major, int generation, String part, String studentId) {
        super(name, major, generation, part);
        this.studentId = studentId;
    }

    @Override
    public String getRoleName() { return "아기사자"; }

    @Override
    public String getRoleSpecificInfo() { return "학번: " + studentId; }
}