package pbl4.domain;

public abstract class Member {
    private String name;
    private String major;
    int generation;
    private String part;

    public Member(String name, String major, int generation, String part) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
    }

    public abstract String getRoleName();
    public abstract String getRoleSpecificInfo();

    public String getName() { return name; }
    public String getMajor() { return major; }
    public int getGeneration() { return generation; }
    public String getPart() { return part; }

    public void printDetail() {
        System.out.println("[" + getRoleName() + "] " + name + " | 전공: " + major +
                " | 기수: " + generation + "기 | 파트: " + part + " | " + getRoleSpecificInfo());
    }
}