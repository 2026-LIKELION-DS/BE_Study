package com.example.pbl_springboot.config;

import com.example.pbl_springboot.MemberRepository;
import com.example.pbl_springboot.MemberService;
import com.example.pbl_springboot.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
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