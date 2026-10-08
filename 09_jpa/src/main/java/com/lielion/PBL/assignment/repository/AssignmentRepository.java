package com.lielion.PBL.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lielion.PBL.assignment.domain.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    /** 메서드 이름 규칙으로 쿼리가 자동 생성된다: where member_id = ? (member.id 기준) */
    List<Assignment> findByMemberId(Long memberId);
}
