package com.likelion.likelionstudy.class7.repository;

import com.likelion.likelionstudy.class7.domain.role.Role;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryMemberRepository implements MemberRepository {
    private final List<Role> store = new ArrayList<>();

    @Override
    public void save(Role member) {
        store.add(member);
    }

    @Override
    public Role findByName(String name) {
        return store.stream()
                .filter(m -> m.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Role> findAll() {
        return new ArrayList<>(store);
    }

    @Override
    public void updateByName(String name, Role member) {
        for (int i = 0; i < store.size(); i++) {
            if (store.get(i).getName().equals(name)) {
                store.set(i, member);
                return;
            }
        }
    }

    @Override
    public boolean deleteByName(String name) {
        return store.removeIf(m -> m.getName().equals(name));
    }

    @Override
    public boolean existsByName(String name) {
        return store.stream().anyMatch(m -> m.getName().equals(name));
    }
}