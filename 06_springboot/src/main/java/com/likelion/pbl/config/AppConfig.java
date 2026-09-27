package com.likelion.pbl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.likelion.pbl.repository.MemberRepository;
import com.likelion.pbl.repository.MemoryMemberRepository;
import com.likelion.pbl.service.MemberService;
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
