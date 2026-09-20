package package2;

import package1.Lion;

public class step3 {

    public static void main(String[] args) {
        Lion lion = new Lion("김멋대", "컴퓨터공학과", 14);
        System.out.println("🦁 아기사자 객체를 생성합니다.");
        System.out.println("🦁 아기사자 정보를 출력합니다.");
        lion.printInfo();
        System.out.println();

        // Step 3-1. public 필드 접근 (다른 패키지에서도 접근/수정 가능)-
        System.out.println("📌 Step 3-1. public 필드 접근을 시도합니다.");
        System.out.println("👉 name 필드 값을 변경합니다.");
        lion.name = "홍길동";
        System.out.println("✅ public 필드 접근 성공");
        System.out.println("🦁 아기사자 정보를 출력합니다.");
        lion.printInfo();

        // Step 3-2. default(package-private) 필드 접근 시도
//         lion.major = "소프트웨어융합학과";

        // Step 3-3. private 필드 접근 시도
//         lion.generation = 20;
    }
}
