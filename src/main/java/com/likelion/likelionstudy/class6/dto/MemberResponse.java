package com.likelion.likelionstudy.class6.dto;

import com.likelion.likelionstudy.class6.domain.Role;

public class MemberResponse {
    private Long id;
    private String roleName;
    private String name;
    private String major;
    private int generation;
    private String part;
    private String detailInfo;

    public MemberResponse(Role role) {
        this.id = role.getId();
        this.roleName = role.getRoleName();
        this.name = role.getName();
        this.major = role.getMajor();
        this.generation = role.getGeneration();
        this.part = role.getPart();
        this.detailInfo = role.getDetailInfo();
    }

    public Long getId() { return id; }
    public String getRoleName() { return roleName; }
    public String getName() { return name; }
    public String getMajor() { return major; }
    public int getGeneration() { return generation; }
    public String getPart() { return part; }
    public String getDetailInfo() { return detailInfo; }
}