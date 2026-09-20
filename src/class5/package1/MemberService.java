package class5.package1;

import class5.role.Role;
import java.util.List;

public class MemberService {
    // Step 1: Service가 Repository를 직접 생성 (강한 결합)
    private final MemberRepository memberRepository = new MemberRepository();

    // 중복 확인 후 멤버 등록
    public boolean register(Role role) {
        if (memberRepository.existsByName(role.getName())) {
            return false;
        }
        memberRepository.save(role);
        return true;
    }

    // 이름으로 멤버 검색
    public Role findMember(String name) {
        return memberRepository.findByName(name);
    }

    // 전체 멤버 조회
    public List<Role> getAllMembers() {
        return memberRepository.findAll();
    }
}