package com.likelion.pbl.dto;

/** POST /members/staffs 요청 본문(JSON)을 담는 DTO. */
public record StaffCreateRequest(
        String name,
        String major,
        int generation,
        String part,
        String position
) {
}
