package hw2.package1;

import java.util.Scanner;

public class Step1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 정보 입력
        System.out.println("🦁 아기사자 이름을 입력해주세요.");
        String name = scanner.nextLine();

        System.out.println("🎓 전공을 입력해주세요.");
        String major = scanner.nextLine();

        System.out.println("📌 기수를 입력해주세요.");
        int generation = scanner.nextInt();

        System.out.println("📌 입력값 검증을 진행합니다.");

        // main에서 유효성 검증
        if (name.trim().isEmpty()) {
            System.out.println("❌ 이름은 비어 있을 수 없습니다.");
            scanner.close();
            return;
        }

        if (major.trim().isEmpty()) {
            System.out.println("❌ 전공은 비어 있을 수 없습니다.");
            scanner.close();
            return;
        }

        if (generation < 1) {
            System.out.println("❌ 기수는 1 이상이어야 합니다.");
            scanner.close();
            return;
        }

        // 검증 통과 후 객체 생성
        System.out.println("⏩ 입력값 검증을 통과하여 아기사자 객체 생성을 진행합니다.");

        Lion lion = new Lion(name, major, generation);

        System.out.println("✅ 아기사자 객체를 성공적으로 생성하였습니다.");

        System.out.println("🦁 아기사자 정보를 출력합니다.");
        lion.printInfo();

        scanner.close();
    }
}