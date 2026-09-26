package com.example.pbl_springboot.class6.config;

import com.example.pbl_springboot.class6.MemberRepository;
import com.example.pbl_springboot.class6.MemberService;
import com.example.pbl_springboot.class6.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;

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