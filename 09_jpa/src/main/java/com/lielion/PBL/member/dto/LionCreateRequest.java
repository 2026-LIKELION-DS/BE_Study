package com.lielion.PBL.member.dto;

/** POST /members/lions 요청 본문 */
public record LionCreateRequest(
        String name,
        String major,
        int generation,
        String part,
        String studentId
) {
}
