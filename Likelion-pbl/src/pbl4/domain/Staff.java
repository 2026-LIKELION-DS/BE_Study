package pbl4.domain;

public class Staff extends Member {
    private String roleTitle;

    public Staff(String name, String major, int generation, String part, String roleTitle) {
        super(name, major, generation, part);
        this.roleTitle = roleTitle;
    }

    @Override
    public String getRoleName() { return "운영진"; }

    @Override
    public String getRoleSpecificInfo() { return "직책: " + roleTitle; }
}