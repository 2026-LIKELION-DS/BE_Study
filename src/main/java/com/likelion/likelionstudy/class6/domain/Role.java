package com.likelion.likelionstudy.class6.domain;

public abstract class Role {
    private Long id;
    private String name;
    private String major;
    private int generation;
    private String part;

    public Role(String name, String major, int generation, String part) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public String getMajor() { return major; }
    public int getGeneration() { return generation; }
    public String getPart() { return part; }

    public abstract String getRoleName();
    public abstract String getDetailInfo();

    public void updateInfo(String major, int generation, String part) {
        this.major = major;
        this.generation = generation;
        this.part = part;
    }
}