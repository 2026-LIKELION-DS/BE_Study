package com.netlion.netflix;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        programLoop:
        while (true) {

            int lionCount = 0;
            while (true) {
                System.out.println("저장할 아기사자 수를 5 이상 입력해주세요. ");

                if (!scanner.hasNextInt()) {
                    System.out.println("[오류] 숫자만 입력할 수 있습니다.");
                    scanner.next();
                    continue;
                }

                lionCount = scanner.nextInt();
                scanner.nextLine();

                if (lionCount < 5) {
                    System.out.println("[오류] 5 이상 입력해주세요.");
                } else {
                    break;
                }
            }

            String[] lionNames = new String[lionCount];

            System.out.println("아기사자 이름을 입력해주세요.");
            int index = 0;
            while (index < lionCount) {
                String name = scanner.nextLine();

                if (name.trim().isEmpty()) {
                    System.out.println("[오류] 이름이 비어있습니다. 다시 입력해주세요.");
                    continue;
                }

                boolean isDuplicate = false;
                for (int i = 0; i < index; i++) {
                    if (lionNames[i].equals(name)) {
                        isDuplicate = true;
                        break;
                    }
                }

                if (isDuplicate) {
                    System.out.println("[오류] 이미 등록된 이름입니다. 다시 입력해주세요.");
                    continue;
                }

                lionNames[index] = name;
                index++;
            }

            System.out.println("아기사자 명단을 최종적으로 출력합니다.");
            for (int i = 0; i < lionNames.length; i++) {
                System.out.println((i + 1) + ". " + lionNames[i]);
            }

            System.out.println("====================");
            while (true) {
                System.out.println("프로그램을 종료하려면 'exit'를 입력하세요.");
                System.out.println("계속 아기사자를 등록하려면 'restart'를 입력하세요.");

                String command = scanner.nextLine();

                if (command.equals("exit")) {
                    System.out.println("아기사자 명단 관리 프로그램을 종료합니다.");
                    break programLoop;
                } else if (command.equals("restart")) {
                    break;
                } else {
                    System.out.println("[오류] 'exit' 또는 'restart' 중 하나만 입력해주세요.");
                }
            }
        }
    }
}