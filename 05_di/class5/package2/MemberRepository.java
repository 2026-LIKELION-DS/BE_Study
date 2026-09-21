package class5.package2;

import java.util.List;

import class5.role.Role;

public interface MemberRepository {

    void save(Role role);

    Role findByName(String name);

    List<Role> findAll();

    boolean existsByName(String name);
}
