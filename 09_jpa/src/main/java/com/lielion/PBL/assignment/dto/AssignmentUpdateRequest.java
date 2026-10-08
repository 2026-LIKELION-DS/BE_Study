package com.lielion.PBL.assignment.dto;

/** PUT /assignments/{id} 요청 본문 */
public record AssignmentUpdateRequest(
        String title,
        String description
) {
}
