package pbl4;

import pbl4.domain.Lion;
import pbl4.domain.Member;
import pbl4.domain.Staff;
import pbl4.repository.MemberRepository;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final MemberRepository repository = new MemberRepository();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n========== 멋쟁이사자처럼 멤버 관리 시스템 ==========");
            System.out.println("1. 멤버 등록");
            System.out.println("2. 전체 멤버 조회");
            System.out.println("3. 이름으로 멤버 검색");
            System.out.println("4. 파트별 멤버 필터링 (Map)");
            System.out.println("0. 프로그램 종료");
            System.out.print("메뉴를 선택하세요: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기

            switch (choice) {
                case 1 -> registerMember();
                case 2 -> printAllMembers();
                case 3 -> searchByName();
                case 4 -> filterByPart();
                case 0 -> {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                }
                default -> System.out.println("[오류] 올바른 메뉴 번호를 입력해 주세요.");
            }
        }
    }

    // 1. 멤버 등록
    private static void registerMember() {
        System.out.print("\n등록할 역할을 선택하세요 (1: 아기사자 / 2: 운영진): ");
        int roleChoice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("이름: ");
        String name = scanner.nextLine();

        // 중복 이름 검사
        if (repository.existsByName(name)) {
            System.out.println("[등록 실패] 이미 존재하는 이름입니다: " + name);
            return;
        }

        System.out.print("전공: ");
        String major = scanner.nextLine();
        System.out.print("기수: ");
        int generation = scanner.nextInt();
        scanner.nextLine();
        System.out.print("파트 (예: BE, FE, PM, Design): ");
        String part = scanner.nextLine();

        if (roleChoice == 1) {
            System.out.print("학번: ");
            String studentId = scanner.nextLine();
            repository.save(new Lion(name, major, generation, part, studentId));
            System.out.println("[성공] 아기사자가 등록되었습니다.");
        } else if (roleChoice == 2) {
            System.out.print("직책 (예: 대표, 백엔드 파트장): ");
            String roleTitle = scanner.nextLine();
            repository.save(new Staff(name, major, generation, part, roleTitle));
            System.out.println("[성공] 운영진이 등록되었습니다.");
        } else {
            System.out.println("[오류] 잘못된 역할 선택입니다.");
        }
    }

    // 2. 전체 멤버 조회
    private static void printAllMembers() {
        List<Member> members = repository.findAll();
        System.out.println("\n===== 전체 멤버 목록 (총 " + members.size() + "명) =====");
        if (members.isEmpty()) {
            System.out.println("등록된 멤버가 없습니다.");
            return;
        }
        for (Member member : members) {
            member.printDetail();
        }
    }

    // 3. 이름으로 멤버 검색
    private static void searchByName() {
        System.out.print("\n검색할 이름 입력: ");
        String name = scanner.nextLine();

        Member member = repository.findByName(name);
        if (member != null) {
            System.out.println("\n[검색 결과]");
            member.printDetail();
        } else {
            System.out.println("[검색 실패] 해당 이름의 멤버를 찾을 수 없습니다.");
        }
    }

    // 4. 파트별 멤버 필터링 (Map)
    private static void filterByPart() {
        Set<String> parts = repository.findAllParts();
        if (parts.isEmpty()) {
            System.out.println("\n등록된 파트 정보가 없습니다.");
            return;
        }

        System.out.println("\n현재 등록된 파트 목록: " + parts);
        System.out.print("조회할 파트명을 입력하세요: ");
        String part = scanner.nextLine();

        List<Member> members = repository.findByPart(part);
        System.out.println("\n===== [" + part + "] 파트 멤버 목록 (총 " + members.size() + "명) =====");
        if (members.isEmpty()) {
            System.out.println("해당 파트에 속한 멤버가 없습니다.");
            return;
        }
        for (Member member : members) {
            member.printDetail();
        }
    }
}