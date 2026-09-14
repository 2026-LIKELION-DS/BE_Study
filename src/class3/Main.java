package class3;

import class3.role.Lion;
import class3.role.Member;
import class3.role.Staff;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== 🦁 아기사자 정보 입력 =====");
        System.out.print("👤 이름: ");
        String lionName = sc.nextLine();
        System.out.print("🚩 전공: ");
        String lionMajor = sc.nextLine();
        System.out.print("📌 기수: ");
        int lionGeneration = Integer.parseInt(sc.nextLine().trim());
        System.out.print("💻 파트 (백엔드/프론트엔드/기획/디자인): ");
        String lionPart = sc.nextLine();
        System.out.print("🆔 학번: ");
        String studentId = sc.nextLine();

        Member lion = new Lion(lionName, lionMajor, lionGeneration, lionPart, studentId);

        System.out.println();
        System.out.println("===== 🎖 운영진 정보 입력 =====");
        System.out.print("👤 이름: ");
        String staffName = sc.nextLine();
        System.out.print("🚩 전공: ");
        String staffMajor = sc.nextLine();
        System.out.print("📌 기수: ");
        int staffGeneration = Integer.parseInt(sc.nextLine().trim());
        System.out.print("💻 파트 (백엔드/프론트엔드/기획/디자인): ");
        String staffPart = sc.nextLine();
        System.out.print("⭐ 직책 (대표/부대표/파트장/멘토): ");
        String position = sc.nextLine();

        Member staff = new Staff(staffName, staffMajor, staffGeneration, staffPart, position);

        sc.close();

        System.out.println();
        System.out.println("===== 📋 결과 출력 =====");
        printResult(lion);
        printResult(staff);
    }

    // Member 타입 하나로 모든 역할을 동일하게 다룬다 — 역할 구분 조건문 없음
    private static void printResult(Member member) {
        System.out.println();
        System.out.println("🎭 역할: " + member.getRoleName());
        System.out.println(member.getCommonInfo());
        System.out.println(member.getDetailInfo());
        String result = member.canSubmitAssignment() ? "✅ 가능" : "❌ 불가능";
        System.out.println("📝 과제 제출 가능 여부: " + result);
        System.out.println("──────────────────────────");
    }
}