package com.likelion.likelionstudy.class5.package2;

import com.likelion.likelionstudy.class5.role.Role;

import java.util.List;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public boolean register(Role role) {
        if (memberRepository.existsByName(role.getName())) {
            return false;
        }
        memberRepository.save(role);
        return true;
    }

    public Role searchByName(String name) {
        return memberRepository.findByName(name);
    }

    public List<Role> getAllMembers() {
        return memberRepository.findAll();
    }
}