package class5.package1;

import class5.role.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {

    private final List<Member> members = new ArrayList<>();

    // 멤버 저장
    public void save(Member member) {
        members.add(member);
    }

    // 전체 조회
    public List<Member> findAll() {
        return members;
    }

    // 이름으로 검색
    public Member findByName(String name) {

        for (Member member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }

        return null;
    }

    // 이름 중복 확인
    public boolean existsByName(String name) {

        for (Member member : members) {
            if (member.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }
}