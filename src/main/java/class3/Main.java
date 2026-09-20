package class3;

import class3.role.Lion;
import class3.role.Member;
import class3.role.Staff;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== 🦁 아기사자 정보 입력 =====");

        System.out.print("👤 이름: ");
        String lionName = scanner.nextLine();

        System.out.print("🎓 전공: ");
        String lionMajor = scanner.nextLine();

        System.out.print("📌 기수: ");
        int lionGeneration = scanner.nextInt();
        scanner.nextLine();

        System.out.print("💻 파트 (백엔드/프론트엔드/기획/디자인): ");
        String lionPart = scanner.nextLine();

        System.out.print("🆔 학번: ");
        String studentId = scanner.nextLine();


        System.out.println();
        System.out.println("===== 👨 운영진 정보 입력 =====");

        System.out.print("👤 이름: ");
        String staffName = scanner.nextLine();

        System.out.print("🎓 전공: ");
        String staffMajor = scanner.nextLine();

        System.out.print("📌 기수: ");
        int staffGeneration = scanner.nextInt();
        scanner.nextLine();

        System.out.print("💻 파트 (백엔드/프론트엔드/기획/디자인): ");
        String staffPart = scanner.nextLine();

        System.out.print("⭐ 직책 (대표/부대표/파트장/멘토): ");
        String position = scanner.nextLine();


        Member lion = new Lion(
                lionName,
                lionMajor,
                lionGeneration,
                lionPart,
                studentId
        );

        Member staff = new Staff(
                staffName,
                staffMajor,
                staffGeneration,
                staffPart,
                position
        );


        System.out.println();
        System.out.println("===== 📋 결과 출력 =====");

        printMember(lion);

        System.out.println("--------------------------");

        printMember(staff);

        scanner.close();
    }


    public static void printMember(Member member) {

        System.out.println(member.getDetailInfo());

        System.out.println(
                "📝 과제 제출 가능 여부: "
                        + member.getSubmitResult()
        );
    }
}