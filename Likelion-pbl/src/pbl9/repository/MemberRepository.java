package pbl9.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pbl9.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByName(String name);
}