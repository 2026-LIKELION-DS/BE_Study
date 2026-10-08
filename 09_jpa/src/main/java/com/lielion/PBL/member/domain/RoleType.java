package com.lielion.PBL.member.domain;

/** 멤버의 역할 구분. DB에는 이름("LION", "STAFF")이 문자열로 저장되고, 화면에 보여줄 이름은 displayName 이다. */
public enum RoleType {
    LION("아기사자"),
    STAFF("운영진");

    private final String displayName;

    RoleType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
