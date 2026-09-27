package pbl6.service;

import pbl6.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service // 스프링 컨테이너가 Service 빈으로 자동 등록
public class MemberService {

    private final MemberRepository memberRepository;

    // 생성자가 1개일 때 @Autowired 생략 가능 (자동 의존성 주입)
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public String getRepositoryInfo() {
        return memberRepository.getRepositoryName();
    }
}