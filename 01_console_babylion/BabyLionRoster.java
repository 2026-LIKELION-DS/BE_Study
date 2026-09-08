import java.util.Scanner;

public class BabyLionRoster {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 1단계 : 아기사자 수 입력
        int lionCount = 0;
        boolean isValid = false;

        while (!isValid) {
            System.out.println("🦁 저장할 아기사자 수를 5 이상 입력해주세요.");
            lionCount = sc.nextInt();

            if (lionCount >= 5) {
                isValid = true; // 조건 만족 -> 반복 종료
            } else {
                System.out.println("❗️[오류] 5 이상 입력해주세요.");
            }
        }

        sc.nextLine();


        // 2단계 : 입력받은 아기사자 수 기준 이름 저장할 배열 생성

        String[] lionNames = new String[lionCount];

        // 3단계 : 이름 입력 ->  배열에 순서대로 저장

        System.out.println("✏️ 아기사자 이름을 입력해주세요.");
        for (int i = 0; i < lionCount; i++) {
            lionNames[i] = sc.nextLine();
        }

        // 4단계 : 배열에 저장된 이름 순서대로 조회 -> 최종 명단 출력
        System.out.println();
        System.out.println("📋 아기사자 명단을 최종적으로 출력합니다.");
        for (int i = 0; i < lionCount; i++) {
            System.out.println((i + 1) + ". " + lionNames[i]);
        }

        sc.close();
    }
}

