package com.likelion.pbl.repository;

import java.util.List;

import com.likelion.pbl.role.Role;
public interface MemberRepository {

    void save(Role role);

    Role findByName(String name);

    List<Role> findAll();

    boolean existsByName(String name);
}
