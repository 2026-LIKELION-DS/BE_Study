package com.likelion.likelionstudy.class4.package1;

import com.likelion.likelionstudy.class4.role.Lion;
import com.likelion.likelionstudy.class4.role.Staff;
import com.likelion.likelionstudy.class4.role.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<User> members = new ArrayList<>();

        while (true) {
            System.out.println("========== 🦁 멤버 관리 시스템 ==========");
            System.out.println("1. 멤버 등록");
            System.out.println("2. 전체 멤버 조회");
            System.out.println("3. 이름으로 검색");
            System.out.println("4. 종료");
            System.out.print("선택: ");

            int menu = Integer.parseInt(scanner.nextLine());
            System.out.println();

            if (menu == 1) {
                System.out.println("― 📝 멤버 등록 ―");
                System.out.print("역할 선택 (1: 아기사자, 2: 운영진): ");
                int roleType = Integer.parseInt(scanner.nextLine());

                System.out.print("👤 이름: ");
                String name = scanner.nextLine();

                boolean exists = false;
                for (User m : members) {
                    if (m.getName().equals(name)) {
                        exists = true;
                        break;
                    }
                }

                if (exists) {
                    System.out.println("❌ 등록 실패: 이미 존재하는 이름입니다.\n");
                    continue;
                }

                System.out.print("🎓 전공: ");
                String major = scanner.nextLine();

                System.out.print("📌 기수: ");
                int gen = Integer.parseInt(scanner.nextLine());

                System.out.print("💻 파트 (백엔드/프론트엔드/기획/디자인): ");
                String part = scanner.nextLine();

                if (roleType == 1) {
                    System.out.print("🆔 학번: ");
                    String studentId = scanner.nextLine();
                    members.add(new Lion(name, major, gen, part, studentId));
                } else {
                    System.out.print("⭐ 직책 (대표/부대표/파트장/멘토): ");
                    String position = scanner.nextLine();
                    members.add(new Staff(name, major, gen, part, position));
                }
                System.out.println("✅ 등록 완료: " + name + "\n");

            } else if (menu == 2) {
                System.out.println("― 📋 전체 멤버 목록 ―");
                for (int i = 0; i < members.size(); i++) {
                    User m = members.get(i);
                    System.out.println((i + 1) + ". [" + m.getRoleName() + "] " + m.getName() + " - " + m.getGeneration() + "기");
                }
                System.out.println("📊 총 " + members.size() + "명\n");

            } else if (menu == 3) {
                System.out.println("― 🔍 이름으로 검색 ―");
                System.out.print("검색할 이름: ");
                String searchName = scanner.nextLine();
                System.out.println();

                boolean found = false;
                for (User m : members) {
                    if (m.getName().equals(searchName)) {
                        System.out.println("✨ [검색 결과]");
                        System.out.println("🎭 역할: " + m.getRoleName());
                        System.out.println("이름: " + m.getName() + " | 전공: " + m.getMajor() + " | 기수: " + m.getGeneration() + " | 파트: " + m.getPart());
                        System.out.println(m.getDetailInfo());
                        String submitStatus = m.canSubmitAssignment() ? "✅ 가능" : "❌ 불가능";
                        System.out.println("📝 과제 제출 가능 여부: " + submitStatus + "\n");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("해당 이름의 멤버를 찾을 수 없습니다.\n");
                }

            } else if (menu == 4) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
        scanner.close();
    }
}   