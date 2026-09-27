package com.example.pbl_week6.repository;

import com.example.pbl_week6.role.Role;
import java.util.List;

public interface MemberRepository {
    void save(Role role);
    Role findByName(String name);
    List<Role> findAll();
    boolean existsByName(String name);
}