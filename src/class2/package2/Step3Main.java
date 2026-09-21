package class2.package2;

import class2.package1.Lion;

public class Step3Main {
    public static void main(String[] args) {
        // 1. 객체 생성
        System.out.println("🦁 아기사자 객체를 생성합니다.");
        Lion lion = new Lion("김멋대", "컴퓨터공학과", 14);
        lion.printInfo();

        System.out.println("📌 Step 3-1. public 필드 접근을 시도합니다.");
        System.out.println("👉 name 필드 값을 변경합니다.");

        // 1. public 필드: 접근 성공
        lion.name = "홍길동";
        System.out.println("✅ public 필드 접근 성공");
        lion.printInfo();

        // 2. default 필드: 다른 패키지에서 접근 불가하여 컴파일 에러 발생 (확인 후 주석 처리)
         //lion.major = "소프트웨어융합학과";

        // 3. private 필드: 외부 클래스에서 접근 불가하여 컴파일 에러 발생 (확인 후 주석 처리)
        //lion.generation = 15;
    }
}