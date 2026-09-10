package class2.package1;

import java.util.Scanner;

public class ValidateBeforeCreate {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("이름을 입력하세요: ");
		String name = scanner.nextLine();

		System.out.print("전공을 입력하세요: ");
		String major = scanner.nextLine();

		System.out.print("기수를 입력하세요: ");
		int generation;
		try {
			generation = Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			generation = -1;
		}

		if (name.isEmpty() || major.isEmpty() || generation < 1) {
			System.out.println("오류: 이름, 전공은 비어 있을 수 없고 기수는 1 이상이어야 합니다.");
			return;
		}

		Lion lion = new Lion(name, major, generation);
		System.out.println("Lion 객체가 생성되었습니다.");
		lion.printInfo();
	}
}
