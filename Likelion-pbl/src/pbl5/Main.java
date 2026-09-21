package pbl5;

import pbl5.domain.Lion;
import pbl5.domain.Member;
import pbl5.domain.Staff;
import pbl5.repository.MemberRepository;
import pbl5.repository.MemoryMemberRepository;
import pbl5.repository.MockMemberRepository;
import pbl5.service.MemberService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // -------------------------------------------------------------
        // [실습] 저장소 구현체를 여기서 교체해보기
        // -------------------------------------------------------------

        // 1. 실제 메모리 저장소 사용할 때:
        MemberRepository repository = new MemoryMemberRepository();

        // 2. Mock 저장소(더미 데이터)로 교체하고 싶을 때: (위 줄을 주석처리하고 아래 줄 주석 해제)
        // MemberRepository repository = new MockMemberRepository();

        // 생성자 주입(DI): Service 코드는 건드리지 않고 Main에서 조립
        MemberService memberService = new MemberService(repository);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n========== [PBL 5] DI/IoC 멤버 관리 시스템 ==========");
            System.out.println("1. 멤버 등록");
            System.out.println("2. 전체 멤버 조회");
            System.out.println("3. 이름으로 멤버 검색");
            System.out.println("0. 프로그램 종료");
            System.out.print("메뉴를 선택하세요: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 제거

            switch (choice) {
                case 1 -> {
                    System.out.print("역할 선택 (1: 아기사자 / 2: 운영진): ");
                    int role = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("이름: ");
                    String name = scanner.nextLine();
                    System.out.print("전공: ");
                    String major = scanner.nextLine();
                    System.out.print("기수: ");
                    int gen = scanner.nextInt();
                    scanner.nextLine();

                    if (role == 1) {
                        System.out.print("학번: ");
                        String studentId = scanner.nextLine();
                        memberService.registerMember(new Lion(name, major, gen, studentId));
                    } else if (role == 2) {
                        System.out.print("직책: ");
                        String roleTitle = scanner.nextLine();
                        memberService.registerMember(new Staff(name, major, gen, roleTitle));
                    }
                }
                case 2 -> {
                    List<Member> members = memberService.getAllMembers();
                    System.out.println("\n===== 전체 멤버 목록 (" + members.size() + "명) =====");
                    for (Member m : members) {
                        m.printDetail();
                    }
                }
                case 3 -> {
                    System.out.print("검색할 이름: ");
                    String searchName = scanner.nextLine();
                    Member m = memberService.searchByName(searchName);
                    if (m != null) {
                        System.out.println("\n[검색 성공]");
                        m.printDetail();
                    } else {
                        System.out.println("\n[검색 실패] 해당 이름의 멤버가 존재하지 않습니다.");
                    }
                }
                case 0 -> {
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("[오류] 메뉴 번호를 다시 확인해 주세요.");
            }
        }
    }
}