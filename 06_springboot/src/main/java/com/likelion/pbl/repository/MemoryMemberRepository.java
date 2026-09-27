package com.likelion.pbl.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.likelion.pbl.role.Role;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    private final List<Role> members = new ArrayList<>();

    @Override
    public void save(Role role) {
        members.add(role);
    }

    @Override
    public Role findByName(String name) {
        for (Role member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    @Override
    public List<Role> findAll() {
        return members;
    }

    @Override
    public boolean existsByName(String name) {
        return findByName(name) != null;
    }

    @Override
    public void updateByName(String name, Role member) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getName().equals(name)) {
                members.set(i, member);
                return;
            }
        }
    }

    @Override
    public boolean deleteByName(String name) {
        return members.removeIf(member -> member.getName().equals(name));
    }
}
