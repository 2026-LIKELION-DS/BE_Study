package class5.package2;

import java.util.List;

import class5.role.Role;

/**
 * (Step 2) 저장소 규약을 정의하는 인터페이스.
 * Service는 구현체(MemoryMemberRepository / MockMemberRepository)가 아니라
 * 이 인터페이스에만 의존한다.
 */
public interface MemberRepository {

    void save(Role role);

    Role findByName(String name);

    List<Role> findAll();

    boolean existsByName(String name);
}
