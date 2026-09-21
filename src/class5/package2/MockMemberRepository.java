package class5.package2;

import class5.role.Lion;
import class5.role.Role;
import class5.role.Staff;
import java.util.ArrayList;
import java.util.List;

public class MockMemberRepository implements MemberRepository {
    private List<Role> dummyData = new ArrayList<>();

    public MockMemberRepository() {
        dummyData.add(new Lion("김사자", "컴퓨터공학과", 14, "백엔드", "2022012345"));
        dummyData.add(new Staff("이운영", "소프트웨어학과", 13, "프론트엔드", "파트장"));
    }

    @Override
    public void save(Role role) {
        System.out.println("(Mock) 저장 요청 무시됨: " + role.getName());
    }

    @Override
    public Role findByName(String name) {
        for (Role r : dummyData) {
            if (r.getName().equals(name)) return r;
        }
        return null;
    }

    @Override
    public List<Role> findAll() {
        return dummyData;
    }

    @Override
    public boolean existsByName(String name) {
        return findByName(name) != null;
    }
}