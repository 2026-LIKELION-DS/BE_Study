package class5.package2;

import java.util.ArrayList;
import java.util.List;

import class5.role.Lion;
import class5.role.Role;
import class5.role.Staff;

public class MockMemberRepository implements MemberRepository {

    private final List<Role> dummyMembers = new ArrayList<>();

    public MockMemberRepository() {
        dummyMembers.add(new Lion("테스트사자", "컴퓨터공학과", 14, "백엔드", "20240101"));
        dummyMembers.add(new Staff("테스트운영진", "소프트웨어학과", 13, "프론트엔드", "파트장"));
    }

    @Override
    public void save(Role role) {
        // Mock은 실제로 저장하지 않는다.
    }

    @Override
    public Role findByName(String name) {
        for (Role member : dummyMembers) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    @Override
    public List<Role> findAll() {
        return dummyMembers;
    }

    @Override
    public boolean existsByName(String name) {
        return findByName(name) != null;
    }
}
