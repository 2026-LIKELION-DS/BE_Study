package com.lielion.PBL.member.dto;

/** POST /members/staffs 요청 본문 */
public record StaffCreateRequest(
        String name,
        String major,
        int generation,
        String part,
        String position
) {
}
