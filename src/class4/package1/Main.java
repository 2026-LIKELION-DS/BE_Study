package class4.package1;

import class4.role.Lion;
import class4.role.Role;
import class4.role.Staff;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Role> memberList = new ArrayList<>();

        while (true) {
            System.out.println("======= 🦁 멤버 관리 시스템 =======");
            System.out.println("1. 멤버 등록");
            System.out.println("2. 전체 멤버 조회");
            System.out.println("3. 이름으로 검색");
            System.out.println("4. 종료");
            System.out.print("선택: ");

            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 1) {
                System.out.println("\n— 📝 멤버 등록 —");
                System.out.print("역할 선택 (1: 아기사자, 2: 운영진): ");
                int roleType = Integer.parseInt(sc.nextLine());

                System.out.print("👤 이름: ");
                String name = sc.nextLine().trim();

                // 중복 검사 (for-each)
                boolean isDuplicate = false;
                for (Role member : memberList) {
                    if (member.getName().equals(name)) {
                        isDuplicate = true;
                        break;
                    }
                }

                if (isDuplicate) {
                    System.out.println("❌ 등록 실패: 이미 존재하는 이름입니다.\n");
                    continue;
                }

                System.out.print("🎓 전공: ");
                String major = sc.nextLine();
                System.out.print("📌 기수: ");
                int gen = Integer.parseInt(sc.nextLine());
                System.out.print("💻 파트 (백엔드/프론트엔드/기획/디자인): ");
                String part = sc.nextLine();
                System.out.print("🆔 학번: ");
                String studentId = sc.nextLine();

                Role newMember;
                if (roleType == 1) {
                    newMember = new Lion(name, major, gen, part, studentId);
                } else {
                    newMember = new Staff(name, major, gen, part, studentId);
                }

                memberList.add(newMember);
                System.out.println("✅ 등록 완료: " + name + "\n");

            } else if (choice == 2) {
                System.out.println("\n— 📋 전체 멤버 목록 —");
                if (memberList.isEmpty()) {
                    System.out.println("등록된 멤버가 없습니다.\n");
                    continue;
                }

                int index = 1;
                for (Role member : memberList) {
                    System.out.printf("%d. [%s] %s - %d기\n",
                            index++, member.getRoleName(), member.getName(), member.getGeneration());
                }
                System.out.println("📊 총 " + memberList.size() + "명\n");

            } else if (choice == 3) {
                System.out.println("\n— 🔍 이름으로 검색 —");
                System.out.print("검색할 이름: ");
                String searchName = sc.nextLine();

                Role foundMember = null;
                for (Role member : memberList) {
                    if (member.getName().equals(searchName)) {
                        foundMember = member;
                        break;
                    }
                }

                if (foundMember != null) {
                    System.out.println("\n✨ [검색 결과]");
                    System.out.println("🎭 역할: " + foundMember.getRoleName());
                    System.out.printf("이름: %s | 전공: %s | 기수: %d | 파트: %s\n",
                            foundMember.getName(), foundMember.getMajor(), foundMember.getGeneration(), foundMember.getPart());
                    System.out.println("   학번: " + foundMember.getStudentId());

                    // 과제 제출 가능 여부 (3주차 Policy 연동 또는 내부 메서드 호출)
                    boolean canSubmit = foundMember.canSubmitAssignment();
                    System.out.println("📝 과제 제출 가능 여부: " + (canSubmit ? "✅ 가능" : "❌ 불가능") + "\n");
                } else {
                    System.out.println("해당 이름의 멤버를 찾을 수 없습니다.\n");
                }

            } else if (choice == 4) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
}