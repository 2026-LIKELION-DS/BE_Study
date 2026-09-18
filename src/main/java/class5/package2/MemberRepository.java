package class5.package2;

import class5.role.Member;

import java.util.List;

public interface MemberRepository {

    void save(Member member);

    List<Member> findAll();

    Member findByName(String name);

    boolean existsByName(String name);
}