package com.likelion.likelionstudy.class6.repository;

import com.likelion.likelionstudy.class6.domain.Role;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MemoryMemberRepository implements MemberRepository {
    private final Map<Long, Role> store = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(0L);

    @Override
    public Role save(Role role) {
        if (role.getId() == null) {
            role.setId(sequence.incrementAndGet());
        }
        store.put(role.getId(), role);
        return role;
    }

    @Override
    public Role findById(Long id) {
        return store.get(id);
    }

    @Override
    public Role findByName(String name) {
        return store.values().stream()
                .filter(m -> m.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Role> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public boolean existsByName(String name) {
        return findByName(name) != null;
    }

    @Override
    public void deleteById(Long id) {
        store.remove(id);
    }
}