package com.netlion.netflix.week5.class5.package2;

import com.netlion.netflix.week5.class5.role.Role;

import java.util.List;

public interface MemberRepository {
    void save(Role role);

    Role findByName(String name);

    List<Role> findAll();

    boolean existsByName(String name);
}
