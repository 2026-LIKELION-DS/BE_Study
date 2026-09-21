package class5.package2;

import java.util.List;
import java.util.Scanner;

import class5.role.Lion;
import class5.role.Role;
import class5.role.Staff;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("🗂 저장소를 선택하세요:");
        System.out.println("1. MemoryMemberRepository (실제 저장)");
        System.out.println("2. MockMemberRepository (더미 데이터)");
        System.out.print("선택: ");
        int repoChoice = Integer.parseInt(sc.nextLine().trim());
        System.out.println();

        // 의존성 조립: 구현체를 만들고 Service 생성자에 주입한다.
        MemberRepository repository = (repoChoice == 1)
                ? new MemoryMemberRepository()
                : new MockMemberRepository();
        MemberService memberService = new MemberService(repository);

        while (true) {
            System.out.println("😋 ===== 멋사 멤버 관리 시스템 (Step 2: DI 적용) ===== 😋");
            System.out.println("1. ➕ 멤버 등록");
            System.out.println("2. 📋 전체 멤버 조회");
            System.out.println("3. 🔍 이름으로 검색");
            System.out.println("4. 📴 종료");
            System.out.print("선택: ");
            int choice = Integer.parseInt(sc.nextLine().trim());

            if (choice == 1) {
                System.out.println();
                System.out.print("👤 역할 선택 (1: 아기사자, 2: 운영진): ");
                int roleChoice = Integer.parseInt(sc.nextLine().trim());

                System.out.println();
                System.out.println("📝 정보 입력");
                System.out.print("이름: ");
                String name = sc.nextLine();
                System.out.print("전공: ");
                String major = sc.nextLine();
                System.out.print("기수: ");
                int generation = Integer.parseInt(sc.nextLine().trim());
                System.out.print("파트: ");
                String part = sc.nextLine();

                Role role;
                if (roleChoice == 1) {
                    System.out.print("학번: ");
                    String studentId = sc.nextLine();
                    role = new Lion(name, major, generation, part, studentId);
                } else {
                    System.out.print("직책: ");
                    String position = sc.nextLine();
                    role = new Staff(name, major, generation, part, position);
                }

                System.out.println();
                boolean registered = memberService.registerMember(role);
                if (registered) {
                    System.out.println("✅ 등록 완료: " + name);
                } else {
                    System.out.println("❌ 등록 실패: 이미 존재하는 이름입니다.");
                }
                System.out.println();

            } else if (choice == 2) {
                System.out.println();
                System.out.println("📋 ===== 전체 멤버 목록 =====");
                List<Role> members = memberService.getAllMembers();
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
                System.out.print("🔍 검색할 이름: ");
                String searchName = sc.nextLine();
                System.out.println();

                Role found = memberService.searchByName(searchName);
                if (found == null) {
                    System.out.println("❌ 해당 이름의 멤버를 찾을 수 없습니다.");
                } else {
                    System.out.println("🎯 ===== 검색 결과 =====");
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
