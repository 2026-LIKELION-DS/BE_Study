package com.example.pbl_week6.repository;

import com.example.pbl_week6.role.Role;
import java.util.ArrayList;
import java.util.List;

public class MemoryMemberRepository implements MemberRepository {
    private final List<Role> store = new ArrayList<>();

    @Override
    public void save(Role role) {
        store.add(role);
    }

    @Override
    public Role findByName(String name) {
        for (Role role : store) {
            if (role.getName().trim().equals(name.trim())) {
                return role;
            }
        }
        return null;
    }

    @Override
    public List<Role> findAll() {
        return new ArrayList<>(store);
    }

    @Override
    public boolean existsByName(String name) {
        return findByName(name) != null;
    }
}