package com.likelion.likelionstudy.class6.dto;

public class LionRegisterRequest {
    private String name;
    private String major;
    private int generation;
    private String part;
    private String studentId;

    public LionRegisterRequest() {}

    public String getName() { return name; }
    public String getMajor() { return major; }
    public int getGeneration() { return generation; }
    public String getPart() { return part; }
    public String getStudentId() { return studentId; }
}