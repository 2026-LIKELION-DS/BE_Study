package com.likelion.likelionstudy.class7.repository;

import com.likelion.likelionstudy.class7.domain.role.Role;

import java.util.List;

public interface MemberRepository {
    void save(Role member);
    Role findByName(String name);
    List<Role> findAll();
    void updateByName(String name, Role member);
    boolean deleteByName(String name);
    boolean existsByName(String name);
}