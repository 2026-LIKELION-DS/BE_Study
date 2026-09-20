package com.netlion.netflix.week5.class5.package1;

import com.netlion.netflix.week5.class5.role.Role;

import java.util.List;

public class MemberService {
    private MemberRepository memberRepository = new MemberRepository();

    public boolean register(Role role) {
        if (memberRepository.existsByName(role.getName())) {
            return false;
        }
        memberRepository.save(role);
        return true;
    }

    public Role findByName(String name) {
        return memberRepository.findByName(name);
    }

    public List<Role> findAll() {
        return memberRepository.findAll();
    }
}
