package com.likelion.pbl.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.likelion.pbl.role.Role;

/**
 * 메모리 기반 저장소: 실제로 List에 데이터를 저장하고 조회한다.
 *
 * @Repository를 붙이면 스프링이 이 클래스를 컴포넌트 스캔으로 찾아
 * 자동으로 Bean 등록을 해준다 (자동 주입 단계에서 AppConfig의 @Bean 메서드를 대신함).
 */
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
