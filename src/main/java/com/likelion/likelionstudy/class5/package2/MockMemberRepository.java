package com.likelion.likelionstudy.class5.package2;

import com.likelion.likelionstudy.class5.role.Lion;
import com.likelion.likelionstudy.class5.role.Role;
import com.likelion.likelionstudy.class5.role.Staff;

import java.util.ArrayList;
import java.util.List;

public class MockMemberRepository implements MemberRepository {
    private final List<Role> dummyStore = new ArrayList<>();

    public MockMemberRepository() {
        dummyStore.add(new Lion("김사자", "컴퓨터공학과", 14, "백엔드", "202020202"));
        dummyStore.add(new Staff("이운영", "소프트웨어학과", 13, "운영진", "대표"));
    }

    @Override
    public void save(Role role) {
    }

    @Override
    public Role findByName(String name) {
        for (Role member : dummyStore) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    @Override
    public List<Role> findAll() {
        return new ArrayList<>(dummyStore);
    }

    @Override
    public boolean existsByName(String name) {
        return findByName(name) != null;
    }
}