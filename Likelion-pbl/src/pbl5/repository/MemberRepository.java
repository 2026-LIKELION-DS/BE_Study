package pbl5.repository;

import pbl5.domain.Member;
import java.util.List;

public interface MemberRepository {
    void save(Member member);
    Member findByName(String name);
    List<Member> findAll();
    boolean existsByName(String name);
}