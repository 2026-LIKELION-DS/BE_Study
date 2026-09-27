package com.likelion.pbl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.likelion.pbl.service.MemberService;

@SpringBootApplication
public class PblApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(PblApplication.class, args);

        MemberService memberService = context.getBean(MemberService.class);
        System.out.println("✅ ApplicationContext에서 꺼낸 Bean: " + memberService);
    }
}
