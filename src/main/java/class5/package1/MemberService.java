package class5.package1;

import class5.role.Member;

import java.util.List;

public class MemberService {

    private final MemberRepository repository = new MemberRepository();

    // 멤버 등록
    public boolean register(Member member) {

        if (repository.existsByName(member.getName())) {
            return false;
        }

        repository.save(member);
        return true;
    }

    // 전체 조회
    public List<Member> getAllMembers() {
        return repository.findAll();
    }

    // 이름 검색
    public Member findMemberByName(String name) {
        return repository.findByName(name);
    }
}