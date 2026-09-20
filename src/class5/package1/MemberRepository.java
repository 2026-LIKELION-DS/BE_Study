package class5.package1;

import class5.role.Role;
import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    private final List<Role> store = new ArrayList<>();

    // 멤버 저장
    public void save(Role role) {
        store.add(role);
    }

    // 이름으로 검색
    public Role findByName(String name) {
        for (Role role : store) {
            if (role.getName().trim().equals(name.trim())) {
                return role;
            }
        }
        return null;
    }

    // 전체 멤버 조회
    public List<Role> findAll() {
        return new ArrayList<>(store);
    }

    // 이름 중복 확인
    public boolean existsByName(String name) {
        return findByName(name) != null;
    }
}