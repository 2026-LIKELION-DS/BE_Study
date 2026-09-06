package com.netlion.netflix;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lionCount = 0;
        while (true) {
            System.out.println("저장할 아기사자 수를 5 이상 입력해주세요.");
            lionCount = scanner.nextInt();

            if (lionCount < 5) {
                System.out.println("[오류] 5 이상 입력해주세요");
            } else {
                break;
            }
        }

        String[] lionNames = new String[lionCount];

        System.out.println("아기사자 이름을 입력해주세요.");
        for (int i = 0; i < lionCount; i++) {
            String name = scanner.next();
            lionNames[i] = name;
        }

        System.out.println("아기사자 명단을 최종적으로 출력합니다.");
        for (int i = 0; i < lionNames.length; i++) {
            System.out.println((i + 1) + ". " + lionNames[i]);
        }
    }
}