package class5.package2;

import class5.role.Lion;
import class5.role.Role;
import class5.role.Staff;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 저장소 선택
        System.out.println("🔧 저장소를 선택하세요:");
        System.out.println("1. MemoryMemberRepository (실제 저장)");
        System.out.println("2. MockMemberRepository (더미 데이터)");
        System.out.print("선택: ");
        int repoChoice = Integer.parseInt(sc.nextLine().trim());

        MemberRepository repository;
        if (repoChoice == 2) {
            repository = new MockMemberRepository();
        } else {
            repository = new MemoryMemberRepository();
        }

        // 2. 의존성 주입 (DI): Main에서 조립하여 Service에 전달
        MemberService service = new MemberService(repository);

        // 3. 시스템 메뉴 실행
        while (true) {
            System.out.println("\n🦁 ===== 멋사 멤버 관리 시스템 (Step 2: DI 적용) ===== 🦁");
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
                    System.out.println("\n✅ 등록 완료: " + name);
                } else {
                    System.out.println("\n❌ 등록 실패: 이미 존재하는 이름입니다.");
                }

            } else if (menu == 2) {
                System.out.println("\n📋 ===== 전체 멤버 목록 =====");
                List<Role> members = service.getAllMembers();
                if (members.isEmpty()) {
                    System.out.println("등록된 멤버가 없습니다.");
                    continue;
                }

                int idx = 1;
                for (Role m : members) {
                    System.out.printf("%d. [%s] %s - %d기\n", idx++, m.getRoleName(), m.getName(), m.getGeneration());
                }
                System.out.println("📊 총 " + members.size() + "명");

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
                    System.out.println("📝 과제 제출 가능: " + (found.canSubmitAssignment() ? "✅ 가능" : "❌ 불가능"));
                } else {
                    System.out.println("해당 이름의 멤버를 찾을 수 없습니다.");
                }

            } else if (menu == 4) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
}
