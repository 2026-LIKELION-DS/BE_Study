package class2.package1;

import java.util.Scanner;

public class ValidateAfterCreate {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("🦁 아기사자 이름을 입력해주세요.");
		String name = scanner.nextLine();

		System.out.println("🐾 전공을 입력해주세요.");
		String major = scanner.nextLine();

		System.out.println("📌 기수를 입력해주세요.");
		int generation;
		try {
			generation = Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			generation = -1;
		}

		Lion lion = new Lion(name, major, generation);
		System.out.println("▶️ 객체 생성이 완료되었습니다. 아기사자 객체의 상태를 확인합니다.");

		String error = lion.validate();
		if (error != null) {
			System.out.println("❌ " + error);
			System.out.println("❌ 잘못된 아기사자 정보입니다.");
			return;
		}

		System.out.println("✅ 아기사자 객체가 자신의 상태를 정상으로 판단했습니다.");
		System.out.println("🦁 아기사자 정보를 출력합니다.");
		lion.printInfo();
	}
}
