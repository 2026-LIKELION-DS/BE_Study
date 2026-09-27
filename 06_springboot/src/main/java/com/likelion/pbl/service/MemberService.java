package com.likelion.pbl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.likelion.pbl.repository.MemberRepository;
import com.likelion.pbl.role.Role;
@Service
public class MemberService {

    private final MemberRepository repository;

    @Autowired
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    /** 이름 중복이 아니면 멤버를 등록한다. 중복이면 false를 반환한다. */
    public boolean registerMember(Role role) {
        if (repository.existsByName(role.getName())) {
            return false;
        }
        repository.save(role);
        return true;
    }

    /** 이름으로 멤버를 검색한다. */
    public Role searchByName(String name) {
        return repository.findByName(name);
    }

    /** 전체 멤버 목록을 반환한다. */
    public List<Role> getAllMembers() {
        return repository.findAll();
    }
}
