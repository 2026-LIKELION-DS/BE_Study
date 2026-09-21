package pbl2.step1;

import pbl2.domain.Lion;
import java.util.Scanner;

public class MainStep1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Step 1: main 메서드에서 유효성 검증 ---");
        System.out.print("이름 입력: ");
        String name = scanner.nextLine();

        System.out.print("전공 입력: ");
        String major = scanner.nextLine();

        System.out.print("기수 입력: ");
        int generation = scanner.nextInt();

        // 1. main 메서드에서 유효성 검증 수행
        System.out.println("\n[Step 1 실행] main 메서드에서 입력값 검증 중...");

        if (name.trim().isEmpty() || major.trim().isEmpty() || generation < 1) {
            System.out.println("[Step 1 오류] 유효하지 않은 입력값이 있습니다. Lion 객체를 생성하지 않습니다.");
        } else {
            // 2. 검증 통과 시에만 객체 생성
            Lion lion = new Lion(name, major, generation);
            System.out.println("[Step 1 성공] Lion 객체가 정상적으로 생성되었습니다.");
            lion.printInfo();
        }

        scanner.close();
    }
}