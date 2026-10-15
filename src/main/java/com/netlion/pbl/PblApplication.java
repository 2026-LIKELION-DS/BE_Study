package com.netlion.pbl;

import com.netlion.pbl.service.MemberService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PblApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PblApplication.class, args);

		MemberService memberService = context.getBean(MemberService.class);
		System.out.println("Bean 가져오기: " + memberService);
	}
}
