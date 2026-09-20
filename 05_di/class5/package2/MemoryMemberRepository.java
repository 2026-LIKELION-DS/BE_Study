package class5.package2;

import java.util.ArrayList;
import java.util.List;

import class5.role.Role;

/** 메모리 기반 저장소: 실제로 List에 데이터를 저장하고 조회한다. */
public class MemoryMemberRepository implements MemberRepository {

    private final List<Role> members = new ArrayList<>();

    @Override
    public void save(Role role) {
        members.add(role);
    }

    @Override
    public Role findByName(String name) {
        for (Role member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    @Override
    public List<Role> findAll() {
        return members;
    }

    @Override
    public boolean existsByName(String name) {
        return findByName(name) != null;
    }
}
