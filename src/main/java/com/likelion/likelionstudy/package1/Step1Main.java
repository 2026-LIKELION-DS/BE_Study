package com.likelion.likelionstudy.package1;

import java.util.Scanner;

public class Step1Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🦁 아기사자 이름을 입력해주세요.");
        String name = scanner.nextLine();

        System.out.println("🎓 전공을 입력해주세요.");
        String major = scanner.nextLine();

        System.out.println("📌 기수를 입력해주세요.");
        int generation = scanner.nextInt();

        System.out.println("📌 입력값 검증을 진행합니다.");

        if (name == null || name.trim().isEmpty() ||
                major == null || major.trim().isEmpty() ||
                generation < 1) {
            System.out.println("❌ 이름은 비어 있을 수 없습니다.");
            return;
        }

        System.out.println("⏩ 입력값 검증을 통과하여 아기사자 객체 생성을 진행합니다.");
        Lion lion = new Lion(name, major, generation);
        System.out.println("✅ 아기사자 객체를 성공적으로 생성하였습니다.");

        lion.printInfo();
    }
}