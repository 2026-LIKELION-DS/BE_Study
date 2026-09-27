package com.likelion.pbl.dto;

/**
 * POST /members/lions 요청 본문(JSON)을 담는 DTO.
 * record를 쓰면 필드·생성자·getter가 한 줄로 끝나고, 불변(immutable)이라 요청 데이터가
 * 중간에 바뀔 걱정도 없다. Jackson이 이 record를 그대로 JSON ↔ 객체로 변환해준다.
 */
public record LionCreateRequest(
        String name,
        String major,
        int generation,
        String part,
        String studentId
) {
}
