package com.lielion.PBL.member.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lielion.PBL.member.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByName(String name);
}
