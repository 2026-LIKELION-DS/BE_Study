package class5;

import class5.repository.MemberRepository;
import class5.repository.MemoryMemberRepository;
import class5.role.Lion;
import class5.role.Role;
import class5.role.Staff;
import class5.service.MemberService;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		MemberRepository memberRepository = new MemoryMemberRepository();
		MemberService memberService = new MemberService(memberRepository);
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
			} else if (choice.equals("4")) {
				searchByPart(scanner, memberService);
			} else if (choice.equals("5")) {
				System.out.println("종료합니다.");
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

	private static void printMenu() {
		System.out.println();
		System.out.println("===== 🦁 멤버 관리 시스템 =====");
		System.out.println("1. 멤버 등록");
		System.out.println("2. 전체 멤버 조회");
		System.out.println("3. 이름으로 검색");
		System.out.println("4. 파트별 조회");
		System.out.println("5. 종료");
		System.out.print("선택: ");
	}

	private static void registerMember(Scanner scanner, MemberService memberService) {
		System.out.println();
		System.out.println("— 📝 멤버 등록 —");
		System.out.print("역할 선택 (1: 아기사자, 2: 운영진): ");
		String roleChoice = scanner.nextLine();

		System.out.print("👤 이름: ");
		String name = scanner.nextLine();

		if (memberService.existsByName(name)) {
			System.out.println("❌ 등록 실패: 이미 존재하는 이름입니다.");
			return;
		}

		System.out.print("🐾 전공: ");
		String major = scanner.nextLine();
		System.out.print("📌 기수: ");
		int generation = parseIntSafely(scanner.nextLine());
		System.out.print("💻 파트 (백엔드/프론트엔드/기획/디자인): ");
		String part = scanner.nextLine();

		Role member;
		if (roleChoice.equals("1")) {
			System.out.print("🆔 학번: ");
			String studentId = scanner.nextLine();
			member = new Lion(name, major, generation, part, studentId);
		} else {
			System.out.print("⭐ 직책: ");
			String position = scanner.nextLine();
			member = new Staff(name, major, generation, part, position);
		}

		memberService.register(member);
		System.out.println("✅ 등록 완료: " + name);
	}

	private static void printAllMembers(MemberService memberService) {
		System.out.println();
		System.out.println("— 📋 전체 멤버 목록 —");
		List<Role> members = memberService.findAll();
		if (members.isEmpty()) {
			System.out.println("등록된 멤버가 없습니다.");
			return;
		}
		for (int i = 0; i < members.size(); i++) {
			Role member = members.get(i);
			System.out.println((i + 1) + ". [" + member.getRoleName() + "] " + member.getName()
				+ " - " + member.getGeneration() + "기");
		}
		System.out.println("📊 총 " + members.size() + "명");
	}

	private static void searchByName(Scanner scanner, MemberService memberService) {
		System.out.println();
		System.out.println("— 🔍 이름으로 검색 —");
		System.out.print("검색할 이름: ");
		String name = scanner.nextLine();

		Optional<Role> found = memberService.findByName(name);
		if (found.isEmpty()) {
			System.out.println("해당 이름의 멤버를 찾을 수 없습니다: " + name);
			return;
		}

		Role member = found.get();
		System.out.println();
		System.out.println("✨ [검색 결과]");
		System.out.println("🦁 역할: " + member.getRoleName());
		System.out.println("이름: " + member.getName() + " | 전공: " + member.getMajor()
			+ " | 기수: " + member.getGeneration() + " | 파트: " + member.getPart());
		System.out.println("    " + member.getDetailInfo());
		System.out.println("📝 과제 제출 가능 여부: " + (member.canSubmit() ? "✅ 가능" : "❌ 불가능"));
	}

	private static void searchByPart(Scanner scanner, MemberService memberService) {
		System.out.println();
		System.out.println("— 💻 파트별 조회 —");
		List<String> parts = memberService.getRegisteredParts();
		System.out.println("📁 등록된 파트: " + parts);
		System.out.print("조회할 파트: ");
		String part = scanner.nextLine();

		List<Role> members = memberService.findByPart(part);
		System.out.println();
		if (members.isEmpty()) {
			System.out.println("해당 파트에 등록된 멤버가 없습니다: " + part);
			return;
		}
		System.out.println("✨ [" + part + " 파트 멤버]");
		for (int i = 0; i < members.size(); i++) {
			Role member = members.get(i);
			System.out.println((i + 1) + ". " + member.getName() + " (" + member.getRoleName() + ") - "
				+ member.getGeneration() + "기");
		}
	}

	private static int parseIntSafely(String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			return 0;
		}
	}
}
