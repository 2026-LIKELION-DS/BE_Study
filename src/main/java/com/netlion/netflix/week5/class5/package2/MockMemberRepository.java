package com.netlion.netflix.week5.class5.package2;

import com.netlion.netflix.week5.class5.role.Lion;
import com.netlion.netflix.week5.class5.role.Role;
import com.netlion.netflix.week5.class5.role.Staff;

import java.util.ArrayList;
import java.util.List;

public class MockMemberRepository implements MemberRepository {
    private List<Role> dummyMembers = new ArrayList<>();

    public MockMemberRepository() {
        dummyMembers.add(new Lion("더미사자", "컴퓨터공학과", 1, "백엔드", "00000000"));
        dummyMembers.add(new Staff("더미운영진", "경영학과", 1, "기획", "멘토"));
    }

    @Override
    public void save(Role role) {
        System.out.println("!! Mock 저장소는 실제로 데이터를 저장하지 않습니다. !!");
    }

    @Override
    public Role findByName(String name) {
        for (Role role : dummyMembers) {
            if (role.getName().equals(name)) {
                return role;
            }
        }
        return null;
    }

    @Override
    public List<Role> findAll() {
        return dummyMembers;
    }

    @Override
    public boolean existsByName(String name) {
        return findByName(name) != null;
    }
}
