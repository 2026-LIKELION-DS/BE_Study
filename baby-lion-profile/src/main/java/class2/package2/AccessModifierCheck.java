package class2.package2;

import class2.package1.Lion;

public class AccessModifierCheck {

	public static void main(String[] args) {
		System.out.println("🦁 아기사자 객체를 생성합니다.");
		Lion lion = new Lion("김멋대", "컴퓨터공학과", 14);

		System.out.println("🦁 아기사자 정보를 출력합니다.");
		lion.printInfo();

		System.out.println();
		System.out.println("📌 Step 3-1. public 필드 접근을 시도합니다.");
		System.out.println("👉 name 필드 값을 변경합니다.");
		lion.name = "홍길동";
		System.out.println("✅ public 필드 접근 성공");
		System.out.println("🦁 아기사자 정보를 출력합니다.");
		lion.printInfo();

		// 📌 Step 3-2. default 필드 접근을 시도합니다.
		// major는 default 접근 제어자라 다른 패키지에서는 컴파일 에러가 발생합니다.
		// java: major is not public in class2.package1.Lion; cannot be accessed from outside package
		// lion.major = "경영학";

		// 📌 Step 3-3. private 필드 접근을 시도합니다.
		// generation은 private이라 클래스 외부에서는 어디서도 컴파일 에러가 발생합니다.
		// java: generation has private access in class2.package1.Lion
		// lion.generation = 5;
	}
}
