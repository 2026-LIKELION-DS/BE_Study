package com.likelion.likelionstudy.class6.repository;

import com.likelion.likelionstudy.class6.domain.Role;

import java.util.List;

public interface MemberRepository {
    Role save(Role role);
    Role findById(Long id);
    Role findByName(String name);
    List<Role> findAll();
    boolean existsByName(String name);
    void deleteById(Long id);
}