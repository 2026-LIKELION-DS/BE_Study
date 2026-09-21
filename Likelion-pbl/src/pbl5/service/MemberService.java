package pbl5.service;

import pbl5.domain.Member;
import pbl5.repository.MemberRepository;

import java.util.List;

public class MemberService {
    // 인터페이스 타입으로 선언 + final로 불변성 보장
    private final MemberRepository memberRepository;

    // [Step 2 의존성 주입 (DI)]: 생성자를 통해 외부에서 구현체를 주입받음
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 멤버 등록 비즈니스 로직 (중복 검사)
    public boolean registerMember(Member member) {
        if (memberRepository.existsByName(member.getName())) {
            System.out.println("[등록 실패] 이미 존재하는 이름입니다: " + member.getName());
            return false;
        }
        memberRepository.save(member);
        System.out.println("[등록 성공] " + member.getName() + " 멤버가 등록되었습니다.");
        return true;
    }

    // 전체 멤버 조회
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    // 이름으로 멤버 검색
    public Member searchByName(String name) {
        return memberRepository.findByName(name);
    }
}