package pbl7.domain;

public abstract class Member {
    private String name;
    private String major;
    private int generation;
    private String part;

    public Member(String name, String major, int generation, String part) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
    }

    public abstract String getRoleName();

    public String getName() { return name; }
    public String getMajor() { return major; }
    public int getGeneration() { return generation; }
    public String getPart() { return part; }

    public void updateCommonInfo(String major, int generation, String part) {
        this.major = major;
        this.generation = generation;
        this.part = part;
    }
}