package com.example.pbl_springboot.class6;

import com.example.pbl_springboot.class6.role.Member;

import java.util.List;

public interface MemberRepository {

    void save(Member member);

    List<Member> findAll();

    Member findByName(String name);

    boolean existsByName(String name);
}