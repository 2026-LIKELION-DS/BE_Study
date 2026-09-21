package class5.package1;

import java.util.ArrayList;
import java.util.List;

import class5.role.Role;

public class MemberRepository {

    private final List<Role> members = new ArrayList<>();

    /** 멤버를 저장소에 추가한다. */
    public void save(Role role) {
        members.add(role);
    }

    /** 이름으로 멤버를 검색한다. 없으면 null을 반환한다. */
    public Role findByName(String name) {
        for (Role member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    /** 전체 멤버 목록을 반환한다. */
    public List<Role> findAll() {
        return members;
    }

    /** 같은 이름의 멤버가 이미 존재하는지 확인한다. */
    public boolean existsByName(String name) {
        return findByName(name) != null;
    }
}
