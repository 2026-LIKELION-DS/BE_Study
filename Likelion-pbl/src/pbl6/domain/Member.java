package pbl6.domain;

public class Member {
    private String name;
    private String major;
    private int generation;

    public Member(String name, String major, int generation) {
        this.name = name;
        this.major = major;
        this.generation = generation;
    }

    public String getName() { return name; }
    public String getMajor() { return major; }
    public int getGeneration() { return generation; }
}