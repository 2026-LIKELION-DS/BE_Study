package com.netlion.pbl.config;

import com.netlion.pbl.repository.MemberRepository;
import com.netlion.pbl.service.MemberService;
import com.netlion.pbl.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @Configuration
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
