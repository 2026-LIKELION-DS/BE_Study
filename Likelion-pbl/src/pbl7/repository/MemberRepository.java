package pbl7.repository;

import pbl7.domain.Member;
import java.util.List;

public interface MemberRepository {
    void save(Member member);
    Member findByName(String name);
    List<Member> findAll();
    boolean existsByName(String name);
    void updateByName(String name, Member member);
    boolean deleteByName(String name);
}