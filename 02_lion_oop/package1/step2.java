package package1;

import java.util.Scanner;

public class step2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("🦁 아기사자 이름을 입력해주세요.");
        String name = sc.nextLine();

        System.out.println("🎓 전공을 입력해주세요.");
        String major = sc.nextLine();

        System.out.println("📌 기수를 입력해주세요.");
        int generation = Integer.parseInt(sc.nextLine());

        // 입력값 유효성과 관계없이 객체부터 생성
        Lion lion = new Lion(name, major, generation);
        System.out.println("▶️ 객체 생성이 완료되었습니다. 아기사자 객체의 상태를 확인합니다.");

        // 객체 스스로 자신의 상태를 검증
        if (lion.isValid()) {
            System.out.println("✅ 아기사자 객체가 자신의 상태를 정상으로 판단했습니다.");
            System.out.println("🦁 아기사자 정보를 출력합니다.");
            lion.printInfo();
        } else {
            System.out.println("❌ 잘못된 아기사자 정보입니다.");
        }

        sc.close();
    }
}
