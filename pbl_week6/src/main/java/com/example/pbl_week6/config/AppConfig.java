package com.example.pbl_week6.config;

import com.example.pbl_week6.repository.MemberRepository;
import com.example.pbl_week6.repository.MemoryMemberRepository;
import com.example.pbl_week6.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
