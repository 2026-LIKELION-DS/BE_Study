package class5.package2;

import class5.role.Lion;
import class5.role.Role;
import class5.role.Staff;

import java.util.ArrayList;
import java.util.List;

public class MockMemberRepository implements MemberRepository {
    private final List<Role> dummyStore = new ArrayList<>();

    public MockMemberRepository() {
        // Mock 데이터 미리 생성
        dummyStore.add(new Lion("김멋사", "컴퓨터공학과", 14, "백엔드", "20240001"));
        dummyStore.add(new Staff("이운영", "소프트웨어학과", 13, "운영진", "20230002"));
    }

    @Override
    public void save(Role role) {
        // Mock 저장소는 실제 저장 로직을 수행하지 않음 (지침 준수)
    }

    @Override
    public Role findByName(String name) {
        for (Role role : dummyStore) {
            if (role.getName().trim().equals(name.trim())) {
                return role;
            }
        }
        return null;
    }

    @Override
    public List<Role> findAll() {
        return new ArrayList<>(dummyStore);
    }

    @Override
    public boolean existsByName(String name) {
        return findByName(name) != null;
    }
}