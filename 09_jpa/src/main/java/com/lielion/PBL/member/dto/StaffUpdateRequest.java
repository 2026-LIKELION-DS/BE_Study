package com.lielion.PBL.member.dto;

/** PUT /members/staffs/{id} 요청 본문 (id는 URL로 받는다) */
public record StaffUpdateRequest(
        String major,
        int generation,
        String part,
        String position
) {
}
