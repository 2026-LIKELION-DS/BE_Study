package com.likelion.likelionstudy.class3;

import com.likelion.likelionstudy.class3.role.Lion;
import com.likelion.likelionstudy.class3.role.Staff;
import com.likelion.likelionstudy.class3.role.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. 아기사자 정보 입력
        System.out.println("========== 🦁 아기사자 정보 입력 ==========");
        System.out.print("👤 이름: ");
        String lionName = scanner.nextLine();

        System.out.print("🎓 전공: ");
        String lionMajor = scanner.nextLine();

        System.out.print("📌 기수: ");
        int lionGen = Integer.parseInt(scanner.nextLine());

        System.out.print("💻 파트 (백엔드/프론트엔드/기획/디자인): ");
        String lionPart = scanner.nextLine();

        System.out.print("🆔 학번: ");
        String studentId = scanner.nextLine();
        System.out.println();

        // 2. 운영진 정보 입력
        System.out.println("========== 🧑‍💼 운영진 정보 입력 ==========");
        System.out.print("👤 이름: ");
        String staffName = scanner.nextLine();

        System.out.print("🎓 전공: ");
        String staffMajor = scanner.nextLine();

        System.out.print("📌 기수: ");
        int staffGen = Integer.parseInt(scanner.nextLine());

        System.out.print("💻 파트 (백엔드/프론트엔드/기획/디자인): ");
        String staffPart = scanner.nextLine();

        System.out.print("⭐ 직책 (대표/부대표/파트장/멘토): ");
        String position = scanner.nextLine();
        System.out.println();

        // 3. 객체 생성 및 부모 타입(User) 리스트로 다형성 관리
        List<User> users = new ArrayList<>();
        users.add(new Lion(lionName, lionMajor, lionGen, lionPart, studentId));
        users.add(new Staff(staffName, staffMajor, staffGen, staffPart, position));

        // 4. 결과 출력 (조건문/instanceof 없이 다형성만 활용)
        System.out.println("========== 📋 결과 출력 ==========");
        System.out.println();

        for (User user : users) {
            System.out.println("🎭 역할: " + user.getRoleName());
            System.out.println("👤 이름: " + user.getName() + " | 🎓 전공: " + user.getMajor()
                    + " | 📌 기수: " + user.getGeneration() + " | 💻 파트: " + user.getPart());
            System.out.println(user.getDetailInfo());

            // 과제 제출 가능 여부 판단 및 출력
            String submitStatus = user.canSubmitAssignment() ? "✅ 가능" : "❌ 불가능";
            System.out.println("📝 과제 제출 가능 여부: " + submitStatus);
            System.out.println("----------------------------------------");
        }

        scanner.close();
    }
}