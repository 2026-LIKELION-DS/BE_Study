package com.example.pbl_springboot.class6;

import com.example.pbl_springboot.class6.MemberRepository;
import com.example.pbl_springboot.class6.role.Member;
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
        return members;
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
    public boolean existsByName(String name) {

        for (Member member : members) {

            if (member.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }
}