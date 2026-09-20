package class5.package2;

import class5.role.Role;
import java.util.List;

public class MemberService {
    // 설계 제약: 인터페이스에만 의존하며, final로 불변 보장
    private final MemberRepository memberRepository;

    // 생성자를 통한 의존성 주입 (DI)
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public boolean register(Role role) {
        if (memberRepository.existsByName(role.getName())) {
            return false;
        }
        memberRepository.save(role);
        return true;
    }

    public Role findMember(String name) {
        return memberRepository.findByName(name);
    }

    public List<Role> getAllMembers() {
        return memberRepository.findAll();
    }
}