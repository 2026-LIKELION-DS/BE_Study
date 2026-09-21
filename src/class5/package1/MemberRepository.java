package class5.package1;

import class5.role.Role;
import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    private List<Role> roles = new ArrayList<>();

    public void save(Role role) {
        roles.add(role);
    }

    public Role findByName(String name) {
        for (Role r : roles) {
            if (r.getName().equals(name)) {
                return r;
            }
        }
        return null;
    }

    public List<Role> findAll() {
        return roles;
    }

    public boolean existsByName(String name) {
        return findByName(name) != null;
    }
}