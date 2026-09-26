package com.example.pbl_springboot.class7.repository;

import com.example.pbl_springboot.class7.role.Member;

import java.util.List;

public interface MemberRepository {

    void save(Member member);

    List<Member> findAll();

    Member findByName(String name);

    void updateByName(String name, Member member);

    boolean deleteByName(String name);

    boolean existsByName(String name);
}