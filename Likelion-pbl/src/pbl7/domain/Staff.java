package pbl7.domain;

public class Staff extends Member {
    private String position;

    public Staff(String name, String major, int generation, String part, String position) {
        super(name, major, generation, part);
        this.position = position;
    }

    @Override
    public String getRoleName() {
        return "운영진";
    }

    public String getPosition() { return position; }

    public void updateStaffInfo(String major, int generation, String part, String position) {
        updateCommonInfo(major, generation, part);
        this.position = position;
    }
}