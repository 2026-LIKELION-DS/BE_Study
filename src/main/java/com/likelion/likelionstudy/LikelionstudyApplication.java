package com.likelion.likelionstudy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class LikelionstudyApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LikelionstudyApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;

        // 1 & 2. 아기사자 수 입력 및 검증 (5 미만일 경우 반복)
        while (true) {
            System.out.println("🦁 저장할 아기사자 수를 5 이상 입력해주세요.");
            count = scanner.nextInt();

            if (count >= 5) {
                break;
            }

            System.out.println("❗ [오류] 5 이상 입력해주세요.");
        }

        // 입력받은 수만큼 이름을 저장할 배열 생성
        String[] names = new String[count];

        // 3. 아기사자 이름 입력받기
        System.out.println("✏️ 아기사자 이름을 입력해주세요.");
        for (int i = 0; i < count; i++) {
            names[i] = scanner.next();
        }

        System.out.println(); // 공백 줄 출력

        // 4. 최종 명단 출력
        System.out.println("📋 아기사자 명단을 최종적으로 출력합니다.");
        for (int i = 0; i < count; i++) {
            System.out.println("🦁 " + (i + 1) + ". " + names[i]);
        }

        scanner.close();
    }
}