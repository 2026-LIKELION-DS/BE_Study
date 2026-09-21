package com.likelion.likelionstudy.package2;

import com.likelion.likelionstudy.package1.Lion;

public class Step3Main {
    public static void main(String[] args) {
        System.out.println("🦁 아기사자 객체를 생성합니다.");
        Lion lion = new Lion("김멋대", "컴퓨터공학과", 14);
        lion.printInfo();

        System.out.println("\n📌 Step 3-1. public 필드 접근을 시도합니다.");
        System.out.println("👉 name 필드 값을 변경합니다.");
        lion.name = "홍길동"; // public이므로 다른 패키지에서도 정상 변경 가능!
        System.out.println("✅ public 필드 접근 성공");
        lion.printInfo();

        // 1. default 필드 접근 시도 (다른 패키지이므로 접근 불가능)
        // lion.major = "소프트웨어학과";
        // 에러 메시지: java: major is not public in com.likelion.likelionstudy.package1.Lion; cannot be accessed from outside package

        // 2. private 필드 접근 시도 (클래스 외부이므로 접근 불가능)
        // lion.generation = 15;
        // 에러 메시지: java: generation has private access in com.likelion.likelionstudy.package1.Lion
    }
}