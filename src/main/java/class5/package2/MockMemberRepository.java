package class5.package2;

import class5.role.Lion;
import class5.role.Member;
import class5.role.Staff;

import java.util.ArrayList;
import java.util.List;

public class MockMemberRepository
        implements MemberRepository {

    private final List<Member> mockMembers = new ArrayList<>();


    public MockMemberRepository() {

        mockMembers.add(
                new Lion(
                        "김사자",
                        "컴퓨터공학과",
                        14,
                        "백엔드",
                        "202020202"
                )
        );

        mockMembers.add(
                new Staff(
                        "홍사자",
                        "소프트웨어학과",
                        13,
                        "프론트엔드",
                        "회장"
                )
        );
    }


    // 실제 저장하지 않음(왜냐면 목 데이터니까)
    @Override
    public void save(Member member) {

    }


    @Override
    public List<Member> findAll() {
        return mockMembers;
    }


    @Override
    public Member findByName(String name) {

        for (Member member : mockMembers) {

            if (member.getName().equals(name)) {
                return member;
            }
        }

        return null;
    }


    @Override
    public boolean existsByName(String name) {

        for (Member member : mockMembers) {

            if (member.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }
}