package com.netlion.netflix.week5.class5.package1;

import com.netlion.netflix.week5.class5.role.Role;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    private List<Role> members = new ArrayList<>();

    public void save(Role role) {
        members.add(role);
    }

    public Role findByName(String name) {
        for (Role role : members) {
            if (role.getName().equals(name)) {
                return role;
            }
        }
        return null;
    }

    public List<Role> findAll() {
        return members;
    }

    public boolean existsByName(String name) {
        return findByName(name) != null;
    }
}
