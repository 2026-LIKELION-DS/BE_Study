package pbl2.step2;

import pbl2.domain.Lion;
import java.util.Scanner;

public class MainStep2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Step 2: 객체 내부에서 유효성 검증 ---");
        System.out.print("이름 입력: ");
        String name = scanner.nextLine();

        System.out.print("전공 입력: ");
        String major = scanner.nextLine();

        System.out.print("기수 입력: ");
        int generation = scanner.nextInt();

        // 1. 검증 여부와 상관없이 먼저 객체 생성
        System.out.println("\n[Step 2 실행] Lion 객체 생성 완료.");
        Lion lion = new Lion(name, major, generation);

        // 2. 객체 스스로 자신의 상태를 검증
        System.out.println("[Step 2 실행] Lion 객체 내부 상태 검증 요청...");
        if (lion.isValid()) {
            System.out.println("[Step 2 성공] 객체 상태가 유효합니다.");
            lion.printInfo();
        } else {
            System.out.println("[Step 2 오류] 객체의 상태가 유효하지 않습니다.");
        }

        scanner.close();
    }
}