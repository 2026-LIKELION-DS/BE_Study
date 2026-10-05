package pbl9.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pbl9.domain.Assignment;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    // 쿼리 메서드 네이밍 규칙: 특정 멤버의 과제 목록 조회
    List<Assignment> findByMemberId(Long memberId);
}