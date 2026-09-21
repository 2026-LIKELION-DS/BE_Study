package com.netlion.netflix.week4.class4.package1;

import com.netlion.netflix.week4.class4.role.Lion;
import com.netlion.netflix.week4.class4.role.Role;
import com.netlion.netflix.week4.class4.role.Staff;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Role> members = new ArrayList<>();

        while (true) {
            System.out.println("======= 멤버 관리 시스템 =======");
            System.out.println("1. 멤버 등록");
            System.out.println("2. 전체 멤버 조회");
            System.out.println("3. 이름으로 검색");
            System.out.println("4. 종료");
            System.out.print("선택: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                register(scanner, members);
            } else if (choice.equals("2")) {
                printAll(members);
            } else if (choice.equals("3")) {
                searchByName(scanner, members);
            } else if (choice.equals("4")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("올바른 번호를 입력해주세요.");
            }
        }
    }

    private static void register(Scanner scanner, List<Role> members) {
        System.out.println("멤버 등록");
        System.out.print("역할 선택 (1: 아기사자, 2: 운영진): ");
        String roleChoice = scanner.nextLine();

        System.out.print("이름: ");
        String name = scanner.nextLine();

        // 중복 이름 검사
        for (Role role : members) {
            if (role.getName().equals(name)) {
                System.out.println("등록 실패: 이미 존재하는 이름입니다.");
                return;
            }
        }

        System.out.print("전공: ");
        String major = scanner.nextLine();
        System.out.print("기수: ");
        int generation = Integer.parseInt(scanner.nextLine());
        System.out.print("파트 (백엔드/프론트엔드/기획/디자인): ");
        String part = scanner.nextLine();

        Role newRole;
        if (roleChoice.equals("1")) {
            System.out.print("학번: ");
            String studentId = scanner.nextLine();
            newRole = new Lion(name, major, generation, part, studentId);
        } else {
            System.out.print("직책 (대표/부대표/파트장/멘토): ");
            String position = scanner.nextLine();
            newRole = new Staff(name, major, generation, part, position);
        }

        members.add(newRole);
        System.out.println("등록 완료: " + name);
    }

    private static void printAll(List<Role> members) {
        System.out.println("전체 멤버 목록");
        if (members.isEmpty()) {
            System.out.println("등록된 멤버가 없습니다.");
            return;
        }
        int index = 1;
        for (Role role : members) {
            System.out.println(index + ". " + role.getSummary());
            index++;
        }
        System.out.println("총 " + members.size() + "명");
    }

    private static void searchByName(Scanner scanner, List<Role> members) {
        System.out.println("이름으로 검색");
        System.out.print("검색할 이름: ");
        String name = scanner.nextLine();

        for (Role role : members) {
            if (role.getName().equals(name)) {
                System.out.println("[검색 결과]");
                System.out.println("역할: " + role.getRoleName());
                System.out.println(role.getDetailInfo());
                String result = role.canSubmit() ? "가능" : "불가능";
                System.out.println("과제 제출 가능 여부: " + result);
                return;
            }
        }
        System.out.println("해당 이름의 멤버를 찾을 수 없습니다.");
    }
}
