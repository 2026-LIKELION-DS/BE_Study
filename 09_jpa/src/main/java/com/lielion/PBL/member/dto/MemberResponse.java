package com.lielion.PBL.member.dto;

import com.lielion.PBL.member.domain.Member;

/**
 * Lion / Staff 공용 응답 DTO.
 * Lion 이면 position 이 null, Staff 면 studentId 가 null 로 내려간다.
 */
public record MemberResponse(
        Long id,
        String name,
        String major,
        int generation,
        String part,
        String roleName,
        String studentId,
        String position
) {

    public static MemberResponse from(Member member) {
        return new MemberResponse(
                member.getId(),
                member.getName(),
                member.getMajor(),
                member.getGeneration(),
                member.getPart(),
                member.getRoleType().getDisplayName(),
                member.getStudentId(),
                member.getPosition()
        );
    }
}
