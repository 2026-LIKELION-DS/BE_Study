package com.lielion.PBL.member.dto;

/** PUT /members/lions/{id} 요청 본문 (id는 URL로 받는다) */
public record LionUpdateRequest(
        String major,
        int generation,
        String part,
        String studentId
) {
}
