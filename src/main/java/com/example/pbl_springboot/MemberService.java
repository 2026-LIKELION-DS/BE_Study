package com.example.pbl_springboot;

import com.example.pbl_springboot.role.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository repository;

    //@Autowired
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public boolean register(Member member) {

        if (repository.existsByName(member.getName())) {
            return false;
        }

        repository.save(member);
        return true;
    }

    public List<Member> getAllMembers() {
        return repository.findAll();
    }

    public Member findMemberByName(String name) {
        return repository.findByName(name);
    }
}