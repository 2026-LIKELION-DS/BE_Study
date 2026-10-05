package com.example.pbl_springboot.class9.member.repository;

import com.example.pbl_springboot.class9.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByName(String name);

    boolean existsByName(String name);
}