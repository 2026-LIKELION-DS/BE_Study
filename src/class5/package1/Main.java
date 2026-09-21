package class5.package1;

import class5.role.Lion;
import class5.role.Role;
import class5.role.Staff;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Main은 Service만 사용 (Repository 직접 접근 금지)
        MemberService service = new MemberService();

        while (true) {
            System.out.println("🦁 ===== 멋사 멤버 관리 시스템 (Step 1) =====");
            System.out.println("1. ➕ 멤버 등록");
            System.out.println("2. 📋 전체 멤버 조회");
            System.out.println("3. 🔍 이름으로 검색");
            System.out.println("4. 🚪 종료");
            System.out.print("선택: ");

            int menu = Integer.parseInt(sc.nextLine().trim());

            if (menu == 1) {
                System.out.print("\n👤 역할 선택 (1: 아기사자, 2: 운영진): ");
                int roleType = Integer.parseInt(sc.nextLine().trim());

                System.out.println("\n📝 정보 입력");
                System.out.print("이름: ");
                String name = sc.nextLine().trim();
                System.out.print("전공: ");
                String major = sc.nextLine().trim();
                System.out.print("기수: ");
                int gen = Integer.parseInt(sc.nextLine().trim());
                System.out.print("파트: ");
                String part = sc.nextLine().trim();
                System.out.print("학번: ");
                String studentId = sc.nextLine().trim();

                Role member;
                if (roleType == 1) {
                    member = new Lion(name, major, gen, part, studentId);
                } else {
                    member = new Staff(name, major, gen, part, studentId);
                }

                boolean isRegistered = service.register(member);
                if (isRegistered) {
                    System.out.println("\n✅ 등록 완료: " + name + "\n");
                } else {
                    System.out.println("\n❌ 등록 실패: 이미 존재하는 이름입니다.\n");
                }

            } else if (menu == 2) {
                System.out.println("\n📋 ===== 전체 멤버 목록 =====");
                List<Role> members = service.getAllMembers();
                if (members.isEmpty()) {
                    System.out.println("등록된 멤버가 없습니다.\n");
                    continue;
                }

                int idx = 1;
                for (Role m : members) {
                    System.out.printf("%d. [%s] %s - %d기\n", idx++, m.getRoleName(), m.getName(), m.getGeneration());
                }
                System.out.println("📊 총 " + members.size() + "명\n");

            } else if (menu == 3) {
                System.out.print("🔍 검색할 이름: ");
                String targetName = sc.nextLine().trim();

                Role found = service.findMember(targetName);
                if (found != null) {
                    System.out.println("\n🎯 ===== 검색 결과 =====");
                    System.out.println("👤 역할: " + found.getRoleName());
                    System.out.printf("📌 이름: %s | 🎓 전공: %s | 🔢 기수: %d | 💻 파트: %s\n",
                            found.getName(), found.getMajor(), found.getGeneration(), found.getPart());
                    System.out.println("🆔 학번: " + found.getStudentId());
                    System.out.println("📝 과제 제출 가능: " + (found.canSubmitAssignment() ? "✅ 가능" : "❌ 불가능") + "\n");
                } else {
                    System.out.println("해당 이름의 멤버를 찾을 수 없습니다.\n");
                }

            } else if (menu == 4) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
}