package com.example.pbl_springboot;

import com.example.pbl_springboot.role.Member;

import java.util.List;

public interface MemberRepository {

    void save(Member member);

    List<Member> findAll();

    Member findByName(String name);

    boolean existsByName(String name);
}