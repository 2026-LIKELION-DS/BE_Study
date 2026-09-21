package com.likelion.likelionstudy.class5.package2;

import com.likelion.likelionstudy.class5.role.Lion;
import com.likelion.likelionstudy.class5.role.Role;
import com.likelion.likelionstudy.class5.role.Staff;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🔧 저장소를 선택하세요:");
        System.out.println("1. MemoryMemberRepository (실제 저장)");
        System.out.println("2. MockMemberRepository (더미 데이터)");
        System.out.print("선택: ");
        int repoType = Integer.parseInt(scanner.nextLine());
        System.out.println();

        MemberRepository repository;
        if (repoType == 1) {
            repository = new MemoryMemberRepository();
        } else {
            repository = new MockMemberRepository();
        }

        MemberService memberService = new MemberService(repository);

        while (true) {
            System.out.println("🦁 ===== 멋사 멤버 관리 시스템 (Step 2: DI 적용) =====");
            System.out.println("1. ➕ 멤버 등록");
            System.out.println("2. 📋 전체 멤버 조회");
            System.out.println("3. 🔍 이름으로 검색");
            System.out.println("4. 🚪 종료");
            System.out.print("선택: ");

            int menu = Integer.parseInt(scanner.nextLine());
            System.out.println();

            if (menu == 1) {
                System.out.print("👤 역할 선택 (1: 아기사자, 2: 운영진): ");
                int roleType = Integer.parseInt(scanner.nextLine());
                System.out.println();

                System.out.println("📝 정보 입력");
                System.out.print("이름: ");
                String name = scanner.nextLine();

                System.out.print("전공: ");
                String major = scanner.nextLine();

                System.out.print("기수: ");
                int gen = Integer.parseInt(scanner.nextLine());

                System.out.print("파트: ");
                String part = scanner.nextLine();

                Role role;
                if (roleType == 1) {
                    System.out.print("학번: ");
                    String studentId = scanner.nextLine();
                    role = new Lion(name, major, gen, part, studentId);
                } else {
                    System.out.print("직책: ");
                    String position = scanner.nextLine();
                    role = new Staff(name, major, gen, part, position);
                }

                boolean isSuccess = memberService.register(role);
                if (isSuccess) {
                    System.out.println("✅ 등록이 완료되었습니다.\n");
                } else {
                    System.out.println("❌ 등록 실패: 이미 존재하는 이름입니다.\n");
                }

            } else if (menu == 2) {
                System.out.println("📋 ===== 전체 멤버 목록 =====");
                List<Role> members = memberService.getAllMembers();
                if (members.isEmpty()) {
                    System.out.println("등록된 멤버가 없습니다.\n");
                } else {
                    for (int i = 0; i < members.size(); i++) {
                        Role m = members.get(i);
                        System.out.println((i + 1) + ". [" + m.getRoleName() + "] " + m.getName() + " - " + m.getGeneration() + "기");
                    }
                    System.out.println();
                }

            } else if (menu == 3) {
                System.out.print("🔍 검색할 이름: ");
                String name = scanner.nextLine();
                System.out.println();

                Role m = memberService.searchByName(name);
                if (m != null) {
                    System.out.println("🎯 ===== 검색 결과 =====");
                    System.out.println("👤 역할: " + m.getRoleName());
                    System.out.println("📌 이름: " + m.getName() + " | 🎓 전공: " + m.getMajor() + " | 🔢 기수: " + m.getGeneration() + " | 💻 파트: " + m.getPart());
                    System.out.println("🆔 " + m.getDetailInfo());
                    String submitStatus = m.canSubmitAssignment() ? "✅ 가능" : "❌ 불가능";
                    System.out.println("📝 과제 제출 가능: " + submitStatus + "\n");
                } else {
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