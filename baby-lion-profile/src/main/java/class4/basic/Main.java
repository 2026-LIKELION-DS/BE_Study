package class4.basic;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		MemberService memberService = new MemberService();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			printMenu();
			String choice = scanner.nextLine();

			if (choice.equals("1")) {
				registerMember(scanner, memberService);
			} else if (choice.equals("2")) {
				printAllMembers(memberService);
			} else if (choice.equals("3")) {
				searchByName(scanner, memberService);
			} else if (choice.equals("0")) {
				System.out.println("종료합니다.");
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

	private static void printMenu() {
		System.out.println();
		System.out.println("===== 메뉴 =====");
		System.out.println("1. 멤버 등록");
		System.out.println("2. 전체 멤버 조회");
		System.out.println("3. 이름으로 검색");
		System.out.println("0. 종료");
		System.out.print("선택: ");
	}

	private static void registerMember(Scanner scanner, MemberService memberService) {
		System.out.print("역할을 선택하세요 (1: 아기사자, 2: 운영진): ");
		String roleChoice = scanner.nextLine();
		String role = roleChoice.equals("1") ? "아기사자" : "운영진";

		System.out.print("이름: ");
		String name = scanner.nextLine();
		System.out.print("전공: ");
		String major = scanner.nextLine();
		System.out.print("기수: ");
		int generation = parseIntSafely(scanner.nextLine());
		System.out.print("파트: ");
		String part = scanner.nextLine();

		String detail;
		if (roleChoice.equals("1")) {
			System.out.print("학번: ");
			detail = scanner.nextLine();
		} else {
			System.out.print("직책: ");
			detail = scanner.nextLine();
		}

		Member member = new Member(name, role, major, generation, part, detail);

		if (memberService.register(member)) {
			System.out.println("✅ 등록 완료: " + name);
		} else {
			System.out.println("❌ 등록 실패: 이미 존재하는 이름입니다 (" + name + ")");
		}
	}

	private static void printAllMembers(MemberService memberService) {
		List<Member> members = memberService.findAll();
		if (members.isEmpty()) {
			System.out.println("등록된 멤버가 없습니다.");
			return;
		}
		System.out.println("===== 전체 멤버 =====");
		for (Member member : members) {
			printMemberInfo(member);
		}
	}

	private static void searchByName(Scanner scanner, MemberService memberService) {
		System.out.print("검색할 이름: ");
		String name = scanner.nextLine();

		Optional<Member> found = memberService.findByName(name);
		if (found.isPresent()) {
			printMemberInfo(found.get());
		} else {
			System.out.println("해당 이름의 멤버를 찾을 수 없습니다: " + name);
		}
	}

	private static void printMemberInfo(Member member) {
		String detailLabel = member.getRole().equals("아기사자") ? "학번" : "직책";
		System.out.println("이름: " + member.getName()
			+ " | 역할: " + member.getRole()
			+ " | 전공: " + member.getMajor()
			+ " | 기수: " + member.getGeneration()
			+ " | 파트: " + member.getPart()
			+ " | " + detailLabel + ": " + member.getDetail());
	}

	private static int parseIntSafely(String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			return 0;
		}
	}
}
