package pbl1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lionCount = 0;

        // 1 & 2단계: 아기사자 수 입력 및 5 미만 검증
        while (true) {
            System.out.print("등록할 아기사자 수를 입력하세요: ");
            lionCount = scanner.nextInt();

            if (lionCount >= 5) {
                break;
            }

            System.out.println("아기사자 수는 5 이상이어야 합니다. 다시 입력해주세요.");
        }

        // 3단계: 입력받은 수만큼 아기사자 이름 입력받아 배열에 저장
        String[] names = new String[lionCount];
        System.out.println("\n아기사자 이름을 입력해주세요.");

        for (int i = 0; i < lionCount; i++) {
            System.out.print((i + 1) + "번째 아기사자 이름: ");
            names[i] = scanner.next();
        }

        // 4단계: 최종 명단 출력
        System.out.println("\n===== 최종 아기사자 명단 =====");
        for (int i = 0; i < names.length; i++) {
            System.out.println((i + 1) + ". " + names[i]);
        }

        scanner.close();
    }
}