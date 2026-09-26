package com.example.pbl_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PblSpringbootApplication {

	public static void main(String[] args) {
		ApplicationContext context =
				SpringApplication.run(PblSpringbootApplication.class, args);

		MemberService memberService =
				context.getBean(MemberService.class);

		System.out.println("MemberService Bean 확인: " + memberService);
	}
}