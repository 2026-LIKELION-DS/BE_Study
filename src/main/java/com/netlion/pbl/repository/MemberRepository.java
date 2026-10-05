package com.netlion.pbl.member.repository;

import com.netlion.pbl.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    boolean existsByName(String name);

    Member findByName(String name);
}
