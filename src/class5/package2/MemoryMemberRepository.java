package class5.package2;

import class5.role.Role;
import java.util.ArrayList;
import java.util.List;

public class MemoryMemberRepository implements MemberRepository {
    private List<Role> roles = new ArrayList<>();

    @Override
    public void save(Role role) {
        roles.add(role);
    }

    @Override
    public Role findByName(String name) {
        for (Role r : roles) {
            if (r.getName().equals(name)) return r;
        }
        return null;
    }

    @Override
    public List<Role> findAll() {
        return roles;
    }

    @Override
    public boolean existsByName(String name) {
        return findByName(name) != null;
    }
}