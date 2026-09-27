package com.likelion.pbl.dto;

import com.likelion.pbl.role.Lion;

/**
 * Lion 응답 DTO. Staff와 필드(studentId vs position)가 다르기 때문에
 * 응답 DTO도 역할별로 분리한다 (Lion에게 없는 position 필드가 JSON에 섞여 나가는 걸 막기 위함).
 */
public record LionResponse(
        String name,
        String major,
        int generation,
        String part,
        String roleName,
        String studentId
) {

    public static LionResponse from(Lion lion) {
        return new LionResponse(
                lion.getName(),
                lion.getMajor(),
                lion.getGeneration(),
                lion.getPart(),
                lion.getRoleName(),
                lion.getStudentId()
        );
    }
}
