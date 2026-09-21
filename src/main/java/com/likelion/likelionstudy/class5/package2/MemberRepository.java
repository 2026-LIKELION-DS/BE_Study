package com.likelion.likelionstudy.class5.package2;

import com.likelion.likelionstudy.class5.role.Role;

import java.util.List;

public interface MemberRepository {
    void save(Role role);
    Role findByName(String name);
    List<Role> findAll();
    boolean existsByName(String name);
}