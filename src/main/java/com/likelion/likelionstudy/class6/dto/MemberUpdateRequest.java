package com.likelion.likelionstudy.class6.dto;

public class MemberUpdateRequest {
    private String major;
    private int generation;
    private String part;

    public MemberUpdateRequest() {}

    public String getMajor() { return major; }
    public int getGeneration() { return generation; }
    public String getPart() { return part; }
}