package com.likelion.pbl.repository;

import java.util.List;

import com.likelion.pbl.role.Role;

/**
 * (5주차와 동일) 저장소 규약을 정의하는 인터페이스.
 * Service는 구현체가 아니라 이 인터페이스에만 의존한다.
 * 7주차에서 수정(updateByName)·삭제(deleteByName) 기능을 추가했다.
 */
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
