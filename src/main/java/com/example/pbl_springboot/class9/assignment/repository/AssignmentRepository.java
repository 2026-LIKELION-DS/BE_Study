package com.example.pbl_springboot.class9.assignment.repository;

import com.example.pbl_springboot.class9.assignment.domain.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    List<Assignment> findByMemberId(Long memberId);
}