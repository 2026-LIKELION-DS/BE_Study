package com.example.pbl_springboot.class7.repository;

import com.example.pbl_springboot.class7.role.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    private final List<Member> members = new ArrayList<>();

    @Override
    public void save(Member member) {
        members.add(member);
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(members);
    }

    @Override
    public Member findByName(String name) {
        for (Member member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }

        return null;
    }

    @Override
    public void updateByName(String name, Member member) {

        for (int i = 0; i < members.size(); i++) {

            if (members.get(i).getName().equals(name)) {
                members.set(i, member);
                return;
            }
        }
    }

    @Override
    public boolean deleteByName(String name) {
        return members.removeIf(
                member -> member.getName().equals(name)
        );
    }

    @Override
    public boolean existsByName(String name) {

        for (Member member : members) {
            if (member.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }
}