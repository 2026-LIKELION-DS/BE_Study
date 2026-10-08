package com.lielion.PBL.assignment.dto;

/** POST /members/{memberId}/assignments 요청 본문 */
public record AssignmentCreateRequest(
        String title,
        String description
) {
}
