package com.likelion.pbl.dto;

/**
 * PUT /members/lions/{name} 요청 본문(JSON)을 담는 DTO.
 * name은 URL 경로(@PathVariable)로 받으므로 여기엔 포함하지 않는다.
 */
public record LionUpdateRequest(
        String major,
        int generation,
        String part,
        String studentId
) {
}
