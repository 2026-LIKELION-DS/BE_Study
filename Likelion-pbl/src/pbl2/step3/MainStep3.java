package pbl2.step3;

import pbl2.domain.Lion;

public class MainStep3 {
    public static void main(String[] args) {
        Lion lion = new Lion("김멋사", "컴퓨터공학과", 12);

        // 1. public 필드 접근 시도
        lion.name = "이멋사"; // 정상 동작 (어디서나 접근 가능)
        System.out.println("변경된 이름: " + lion.name);

        // 2. default 필드 접근 시도
        // lion.major = "소프트웨어학과";
        // -> [컴파일 에러 발생!] java: major is not public in pbl2.domain.Lion; cannot be accessed from outside package
        // 이유: major는 default(package-private) 접근 제어자이므로 다른 패키지(step3)에서 접근 불가

        // 3. private 필드 접근 시도
        // lion.generation = 13;
        // -> [컴파일 에러 발생!] java: generation has private access in pbl2.domain.Lion
        // 이유: generation은 private 접근 제어자이므로 외부 클래스에서 직접 접근 불가
    }
}
