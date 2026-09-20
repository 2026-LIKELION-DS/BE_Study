package class3;

import java.util.Scanner;

import class3.role.Lion;
import class3.role.Member;
import class3.role.Staff;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== 🦁 아기사자 정보 입력 =====");
        System.out.println("👤 이름: ");
        String lionName = sc.nextLine();
        System.out.println("🎓 전공: ");
        String lionMajor = sc.nextLine();
        System.out.println("📌 기수: ");
        int lionGeneration = Integer.parseInt(sc.nextLine());
        System.out.println("💻 파트 (백엔드/프론트엔드/기획/디자인): ");
        String lionPart = sc.nextLine();
        System.out.println("🆔 학번: ");
        String studentId = sc.nextLine();

        Member lion = new Lion(lionName, lionMajor, lionGeneration, lionPart, studentId);

        System.out.println();
        System.out.println("===== 👑 운영진 정보 입력 =====");
        System.out.println("👤 이름: ");
        String staffName = sc.nextLine();
        System.out.println("🎓 전공: ");
        String staffMajor = sc.nextLine();
        System.out.println("📌 기수: ");
        int staffGeneration = Integer.parseInt(sc.nextLine());
        System.out.println("💻 파트 (백엔드/프론트엔드/기획/디자인): ");
        String staffPart = sc.nextLine();
        System.out.println("⭐ 직책 (대표/부대표/파트장/멘토): ");
        String position = sc.nextLine();

        Member staff = new Staff(staffName, staffMajor, staffGeneration, staffPart, position);

        Member[] members = { lion, staff };

        System.out.println();
        System.out.println("===== 📋 결과 출력 =====");
        for (Member member : members) {
            System.out.println(member.getDetailInfo());
            System.out.println("📝 과제 제출 가능 여부: " + (member.canSubmit() ? "✅ 가능" : "❌ 불가능"));
            System.out.println();
        }

        sc.close();
    }
}
