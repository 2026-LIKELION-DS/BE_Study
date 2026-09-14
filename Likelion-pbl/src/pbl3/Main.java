package pbl3;

import pbl3.domain.Lion;
import pbl3.domain.Member;
import pbl3.domain.Staff;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. 아기사자 정보 입력
        System.out.println("===== [1] 아기사자 정보 입력 =====");
        System.out.print("이름: ");
        String lionName = scanner.next();
        System.out.print("전공: ");
        String lionMajor = scanner.next();
        System.out.print("기수: ");
        int lionGen = scanner.nextInt();
        System.out.print("파트: ");
        String lionPart = scanner.next();
        System.out.print("학번: ");
        String studentId = scanner.next();

        Member lion = new Lion(lionName, lionMajor, lionGen, lionPart, studentId);

        // 2. 운영진 정보 입력
        System.out.println("\n===== [2] 운영진 정보 입력 =====");
        System.out.print("이름: ");
        String staffName = scanner.next();
        System.out.print("전공: ");
        String staffMajor = scanner.next();
        System.out.print("기수: ");
        int staffGen = scanner.nextInt();
        System.out.print("파트: ");
        String staffPart = scanner.next();
        System.out.print("직책: ");
        String roleTitle = scanner.next();

        Member staff = new Staff(staffName, staffMajor, staffGen, staffPart, roleTitle);

        // 3. 다형성을 활용한 정보 출력 및 제출 정책 확인
        Member[] members = {lion, staff};

        System.out.println("\n===== [3] 최종 구성원 명단 및 과제 제출 가능 여부 =====");
        for (Member member : members) {
            System.out.println("----------------------------------------");
            System.out.println("[" + member.getClass().getSimpleName() + "]");
            System.out.println("이름: " + member.getName() + " | 전공: " + member.getMajor() +
                    " | 기수: " + member.getGeneration() + "기 | 파트: " + member.getPart());
            System.out.println(member.getRoleSpecificInfo());

            // 조건문 없이 다형성을 이용해 판단 실행
            boolean canSubmit = member.canSubmitAssignment();
            System.out.println("과제 제출 가능 여부: " + (canSubmit ? "제출 가능" : "제출 불가능"));
        }

        scanner.close();
    }
}