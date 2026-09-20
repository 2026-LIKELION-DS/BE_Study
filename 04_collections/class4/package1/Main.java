package class4.package1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import class4.role.Lion;
import class4.role.Role;
import class4.role.Staff;

/**
 * (Step 1) List<Role>만 사용해 멤버를 등록/조회/검색하는 메뉴 기반 프로그램.
 * 배열 대신 List를 써서 크기를 미리 정하지 않고 동적으로 멤버를 추가한다.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Role> members = new ArrayList<>();

        while (true) {
            System.out.println("===== 🦁 멤버 관리 시스템 =====");
            System.out.println("1. 멤버 등록");
            System.out.println("2. 전체 멤버 조회");
            System.out.println("3. 이름으로 검색");
            System.out.println("4. 종료");
            System.out.print("선택: ");
            int choice = Integer.parseInt(sc.nextLine().trim());

            if (choice == 1) {
                System.out.println();
                System.out.println("— 📝 멤버 등록 —");
                System.out.print("역할 선택 (1: 아기사자, 2: 운영진): ");
                int roleChoice = Integer.parseInt(sc.nextLine().trim());

                System.out.print("👤 이름: ");
                String name = sc.nextLine();

                // 이름을 받자마자 중복부터 확인한다 (중복이면 나머지 정보는 입력받지 않는다)
                boolean duplicate = false;
                for (Role existing : members) {
                    if (existing.getName().equals(name)) {
                        duplicate = true;
                        break;
                    }
                }

                if (duplicate) {
                    System.out.println("❌ 등록 실패: 이미 존재하는 이름입니다.");
                } else {
                    System.out.print("🎓 전공: ");
                    String major = sc.nextLine();
                    System.out.print("📌 기수: ");
                    int generation = Integer.parseInt(sc.nextLine().trim());
                    System.out.print("💻 파트 (백엔드/프론트엔드/기획/디자인): ");
                    String part = sc.nextLine();

                    Role role;
                    if (roleChoice == 1) {
                        System.out.print("🆔 학번: ");
                        String studentId = sc.nextLine();
                        role = new Lion(name, major, generation, part, studentId);
                    } else {
                        System.out.print("⭐ 직책 (대표/부대표/파트장/멘토): ");
                        String position = sc.nextLine();
                        role = new Staff(name, major, generation, part, position);
                    }

                    members.add(role);
                    System.out.println("✅ 등록 완료: " + name);
                }
                System.out.println();

            } else if (choice == 2) {
                System.out.println();
                System.out.println("— 📋 전체 멤버 목록 —");
                int index = 1;
                for (Role member : members) {
                    System.out.println(index + ". [" + member.getRoleName() + "] "
                            + member.getName() + " - " + member.getGeneration() + "기");
                    index++;
                }
                System.out.println("📊 총 " + members.size() + "명");
                System.out.println();

            } else if (choice == 3) {
                System.out.println();
                System.out.println("— 🔍 이름으로 검색 —");
                System.out.print("검색할 이름: ");
                String searchName = sc.nextLine();
                System.out.println();

                Role found = null;
                for (Role member : members) {
                    if (member.getName().equals(searchName)) {
                        found = member;
                        break;
                    }
                }

                if (found == null) {
                    System.out.println("❌ 해당 이름의 멤버를 찾을 수 없습니다.");
                } else {
                    System.out.println("✨ [검색 결과]");
                    System.out.println(found.getDetailInfo());
                    System.out.println("📝 과제 제출 가능 여부: " + (found.canSubmit() ? "✅ 가능" : "❌ 불가능"));
                }
                System.out.println();

            } else if (choice == 4) {
                break;
            }
        }

        sc.close();
    }
}
