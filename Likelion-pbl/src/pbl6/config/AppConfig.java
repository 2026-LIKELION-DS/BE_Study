package pbl6.config;

import pbl6.repository.MemberRepository;
import pbl6.repository.MemoryMemberRepository;
import pbl6.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration과 @Bean을 이용한 수동 등록 예시
// (사용 시 Service와 Repository 클래스의 @Service, @Repository 어노테이션을 주석 처리)
@Configuration
public class AppConfig {

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
}