package class3;

import class3.role.Lion;
import class3.role.Member;
import class3.role.Staff;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. 아기사자 정보 입력
        System.out.println("======== 🦁 아기사자 정보 입력 ========");
        System.out.print("👤 이름: ");
        String lionName = scanner.nextLine();

        System.out.print("🎓 전공: ");
        String lionMajor = scanner.nextLine();

        System.out.print("📌 기수: ");
        int lionGen = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("💻 파트 (백엔드/프론트엔드/기획/디자인): ");
        String lionPart = scanner.nextLine();

        System.out.print("🆔 학번: ");
        String studentId = scanner.nextLine();

        Member lion = new Lion(lionName, lionMajor, lionGen, lionPart, studentId);
        System.out.println();

        // 2. 운영진 정보 입력
        System.out.println("======== 👨‍💼 운영진 정보 입력 ========");
        System.out.print("👤 이름: ");
        String staffName = scanner.nextLine();

        System.out.print("🎓 전공: ");
        String staffMajor = scanner.nextLine();

        System.out.print("📌 기수: ");
        int staffGen = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("💻 파트 (백엔드/프론트엔드/기획/디자인): ");
        String staffPart = scanner.nextLine();

        System.out.print("⭐ 직책 (대표/부대표/파트장/멘토): ");
        String position = scanner.nextLine();

        Member staff = new Staff(staffName, staffMajor, staffGen, staffPart, position);
        System.out.println();

        // 3. 결과 출력
        Member[] members = {lion, staff};

        System.out.println("======== 📋 결과 출력 ========");
        for (Member member : members) {
            printMemberInfo(member);
            System.out.println();
        }
    }

    private static void printMemberInfo(Member member) {
        System.out.println(member.getDetails());
        String submissionStatus = member.canSubmit() ? "✅ 가능" : "❌ 불가능";
        System.out.println("📝 과제 제출 가능 여부: " + submissionStatus);
    }
}