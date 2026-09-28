package com.likelion.likelionstudy.class8.dto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LionUpdateRequest {
    private String name;
    private String studentId;
    private String major;
    private int generation;
    private String part;

    public String getName() { return name; }
    public String getStudentId() { return studentId; }
    public String getMajor() { return major; }
    public int getGeneration() { return generation; }
    public String getPart() { return part; }
}