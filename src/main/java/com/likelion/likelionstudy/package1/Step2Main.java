package com.likelion.likelionstudy.package1;

import java.util.Scanner;

public class Step2Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🦁 아기사자 이름을 입력해주세요.");
        String name = scanner.nextLine();

        System.out.println("🎓 전공을 입력해주세요.");
        String major = scanner.nextLine();

        System.out.println("📌 기수를 입력해주세요.");
        int generation = scanner.nextInt();
        scanner.nextLine();

        Lion lion = new Lion(name, major, generation);
        System.out.println("⏩ 객체 생성이 완료되었습니다. 아기사자 객체의 상태를 확인합니다.");

        if (lion.validateSelf()) {
            lion.printInfo();

            // 보너스 과제
            System.out.println("\n❓ 아기사자 정보를 수정하시겠습니까? (네 / 아니요)");
            String answer = scanner.nextLine();

            if ("네".equals(answer)) {
                System.out.println("✏️ 수정할 항목을 선택해주세요 (1: 이름 / 2: 전공 / 3: 기수)");
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 1) {
                    System.out.println("새로운 이름을 입력해주세요:");
                    String newName = scanner.nextLine();
                    lion.updateName(newName);
                } else if (choice == 2) {
                    System.out.println("새로운 전공을 입력해주세요:");
                    String newMajor = scanner.nextLine();
                    lion.updateMajor(newMajor);
                } else if (choice == 3) {
                    System.out.println("새로운 기수를 입력해주세요:");
                    int newGen = scanner.nextInt();
                    lion.updateGeneration(newGen);
                }

                lion.printInfo();
            }
        }
    }
}