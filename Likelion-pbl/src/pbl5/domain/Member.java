package pbl5.domain;

public abstract class Member {
    private String name;
    private String major;
    private int generation;

    public Member(String name, String major, int generation) {
        this.name = name;
        this.major = major;
        this.generation = generation;
    }

    public abstract String getRoleName();
    public abstract String getRoleSpecificInfo();

    public String getName() { return name; }
    public String getMajor() { return major; }
    public int getGeneration() { return generation; }

    public void printDetail() {
        System.out.println("[" + getRoleName() + "] " + name + " | 전공: " + major +
                " | 기수: " + generation + "기 | " + getRoleSpecificInfo());
    }
}