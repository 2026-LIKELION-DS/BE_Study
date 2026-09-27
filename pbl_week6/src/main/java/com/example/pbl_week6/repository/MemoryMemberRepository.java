package com.example.pbl_week6.repository;

import com.example.pbl_week6.role.Role;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
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

    @Override
    public void updateByName(String name, Role member) {
        for (int i = 0; i < store.size(); i++) {
            if (store.get(i).getName().trim().equals(name.trim())) {
                store.set(i, member);
                return;
            }
        }
    }

    @Override
    public boolean deleteByName(String name) {
        return store.removeIf(role -> role.getName().trim().equals(name.trim()));
    }
}