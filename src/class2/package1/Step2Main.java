package class2.package1;

import java.util.Scanner;

public class Step2Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. 입력 받기
        System.out.println("🦁 아기사자 이름을 입력해주세요.");
        String name = scanner.nextLine();

        System.out.println("📕 전공을 입력해주세요.");
        String major = scanner.nextLine();

        System.out.println("👉 기수를 입력해주세요.");
        int generation = Integer.parseInt(scanner.nextLine());

        // 2. 입력값에 상관없이 Lion 객체 먼저 생성
        Lion lion = new Lion(name, major, generation);
        System.out.println("⏩ 객체 생성이 완료되었습니다. 아기사자 객체의 상태를 확인합니다.");

        // 3. 객체의 검증 메서드 호출
        if (lion.isValid()) {
            System.out.println("✅ 아기사자 객체가 자신의 상태를 정상으로 판단했습니다.");
            lion.printInfo();
        } else {
            System.out.println("❌ 잘못된 아기사자 정보입니다.");
        }
    }
}
