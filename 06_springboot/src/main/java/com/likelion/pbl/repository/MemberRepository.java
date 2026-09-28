package com.likelion.pbl.repository;

import java.util.List;

import com.likelion.pbl.role.Role;

public interface MemberRepository {

    void save(Role role);

    Role findByName(String name);

    List<Role> findAll();

    boolean existsByName(String name);

    /** 이름으로 기존 멤버를 찾아 새 Role 객체로 통째로 교체한다. */
    void updateByName(String name, Role member);

    /** 이름으로 멤버를 삭제한다. 삭제됐으면 true, 대상이 없었으면 false. */
    boolean deleteByName(String name);
}
