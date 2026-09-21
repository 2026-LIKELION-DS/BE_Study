package com.likelion.likelionstudy.class5.package1;

import com.likelion.likelionstudy.class5.role.Role;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    private final List<Role> store = new ArrayList<>();

    public void save(Role role) {
        store.add(role);
    }

    public Role findByName(String name) {
        for (Role member : store) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    public List<Role> findAll() {
        return new ArrayList<>(store);
    }

    public boolean existsByName(String name) {
        return findByName(name) != null;
    }
}