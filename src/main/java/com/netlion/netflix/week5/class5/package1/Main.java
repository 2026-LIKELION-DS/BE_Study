package com.netlion.netflix.week5.class5.package1;

import com.netlion.netflix.week5.class5.role.Lion;
import com.netlion.netflix.week5.class5.role.Role;
import com.netlion.netflix.week5.class5.role.Staff;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MemberService memberService = new MemberService();

        while (true) {
            System.out.println("===== 멋사 멤버 관리 시스템 =====");
            System.out.println("1. 멤버 등록");
            System.out.println("2. 전체 멤버 조회");
            System.out.println("3. 이름으로 검색");
            System.out.println("4. 종료");
            System.out.print("선택: ");
            int menu = Integer.parseInt(scanner.nextLine());

            if (menu == 1) {
                System.out.print("역할 선택 (1: 아기사자, 2: 운영진): ");
                int roleType = Integer.parseInt(scanner.nextLine());

                System.out.println("정보 입력");
                System.out.print("이름: ");
                String name = scanner.nextLine();
                System.out.print("전공: ");
                String major = scanner.nextLine();
                System.out.print("기수: ");
                int generation = Integer.parseInt(scanner.nextLine());
                System.out.print("파트: ");
                String part = scanner.nextLine();

                Role role;
                if (roleType == 1) {
                    System.out.print("학번: ");
                    String studentId = scanner.nextLine();
                    role = new Lion(name, major, generation, part, studentId);
                } else {
                    System.out.print("직책: ");
                    String position = scanner.nextLine();
                    role = new Staff(name, major, generation, part, position);
                }

                boolean success = memberService.register(role);
                if (success) {
                    System.out.println("등록 완료: " + name);
                } else {
                    System.out.println("등록 실패: 이미 존재하는 이름입니다.");
                }

            } else if (menu == 2) {
                System.out.println("전체 멤버 목록");
                List<Role> all = memberService.findAll();
                int index = 1;
                for (Role role : all) {
                    System.out.println(index + ". [" + role.getRoleName() + "] " + role.getName());
                    index++;
                }
                System.out.println("총 " + all.size() + "명");

            } else if (menu == 3) {
                System.out.print("검색할 이름: ");
                String searchName = scanner.nextLine();
                Role found = memberService.findByName(searchName);

                if (found == null) {
                    System.out.println("해당 이름의 멤버를 찾을 수 없습니다.");
                } else {
                    System.out.println("[검색 결과]");
                    System.out.println("역할: " + found.getRoleName());
                    System.out.println(found.getDetailInfo());
                    String submit = found.canSubmit() ? "가능" : "불가능";
                    System.out.println("과제 제출 가능 여부: " + submit);
                }

            } else if (menu == 4) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
}
