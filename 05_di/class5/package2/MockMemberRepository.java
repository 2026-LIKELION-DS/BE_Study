package class5.package2;

import java.util.ArrayList;
import java.util.List;

import class5.role.Lion;
import class5.role.Role;
import class5.role.Staff;

/**
 * Mock 저장소: 미리 정의된 더미 데이터만 반환한다.
 * save()를 호출해도 실제로 저장되지 않는다 (등록해도 목록이 늘어나지 않음을 체험시키기 위함).
 */
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
