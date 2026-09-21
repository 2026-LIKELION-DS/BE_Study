package class5.package2;

import class5.role.Lion;
import class5.role.Role;
import class5.role.Staff;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static MemberService memberService;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("🔧 저장소를 선택하세요:");
        System.out.println("1. MemoryMemberRepository (실제 저장)");
        System.out.println("2. MockMemberRepository (더미 데이터)");
        System.out.print("선택: ");
        String repoChoice = sc.nextLine().trim();

        MemberRepository repository = repoChoice.equals("2")
                ? new MockMemberRepository()
                : new MemoryMemberRepository();

        memberService = new MemberService(repository);

        while (true) {
            System.out.println("\n🦁 ===== 멋사 멤버 관리 시스템 (Step 2: DI 적용) ===== 🦁");
            System.out.println("1. 📝 멤버 등록");
            System.out.println("2. 📋 전체 멤버 조회");
            System.out.println("3. 🔍 이름으로 검색");
            System.out.println("4. 🚪 종료");
            System.out.print("선택: ");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1": registerMember(); break;
                case "2": printAllMembers(); break;
                case "3": searchByName(); break;
                case "4":
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    return;
                default:
                    System.out.println("❌ 잘못된 입력입니다.");
            }
        }
    }

    private static void registerMember() {
        System.out.print("역할 선택 (1: 아기사자, 2: 운영진): ");
        String roleChoice = sc.nextLine().trim();

        System.out.print("이름: ");
        String name = sc.nextLine();

        System.out.print("전공: ");
        String major = sc.nextLine();

        System.out.print("기수: ");
        int generation;
        try {
            generation = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("❌ 기수는 숫자만 입력할 수 있습니다.");
            return;
        }

        System.out.print("파트: ");
        String part = sc.nextLine();

        Role role;
        if (roleChoice.equals("1")) {
            System.out.print("학번: ");
            role = new Lion(name, major, generation, part, sc.nextLine());
        } else if (roleChoice.equals("2")) {
            System.out.print("직책: ");
            role = new Staff(name, major, generation, part, sc.nextLine());
        } else {
            System.out.println("❌ 잘못된 역할 선택입니다.");
            return;
        }

        if (memberService.register(role)) {
            System.out.println("✅ 등록 완료: " + name);
        } else {
            System.out.println("❌ 등록 실패: 이미 존재하는 이름입니다.");
        }
    }

    private static void printAllMembers() {
        List<Role> roles = memberService.findAll();
        if (roles.isEmpty()) {
            System.out.println("등록된 멤버가 없습니다.");
            return;
        }
        for (int i = 0; i < roles.size(); i++) {
            Role r = roles.get(i);
            System.out.println((i + 1) + ". [" + r.getRoleName() + "] " + r.getName() + " - " + r.getGeneration() + "기");
        }
    }

    private static void searchByName() {
        System.out.print("검색할 이름: ");
        Role r = memberService.findByName(sc.nextLine());
        if (r == null) {
            System.out.println("❌ 해당 이름의 멤버를 찾을 수 없습니다.");
            return;
        }
        System.out.println("역할: " + r.getRoleName());
        System.out.println(r.getCommonInfo());
        System.out.println(r.getDetailInfo());
        System.out.println("과제 제출 가능: " + (r.canSubmitAssignment() ? "✅" : "❌"));
    }
}