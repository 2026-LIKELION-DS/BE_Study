package com.lielion.PBL.member.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lielion.PBL.member.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

    /** 메서드 이름 규칙 findBy + 필드명 → select ... from member where name = ? 이 자동 생성된다. */
    Optional<Member> findByName(String name);
}
