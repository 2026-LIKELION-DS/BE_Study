import java.util.Scanner;

public class hw1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = 0;

        while (count < 5) {
            System.out.println("저장할 아기사자 수를 5 이상 입력해주세요.");
            count = scanner.nextInt();

            if (count < 5) {
                System.out.println("![오류] 5 이상 입력해주세요.");
            }
        }

        // 입력된 수만큼 이름을 저장할 배열 생성
        String[] names = new String[count];
        scanner.nextLine();

        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + "번째 아기사자 이름을 입력하세요:");
            names[i] = scanner.nextLine();
        }

        // 최종 명단 출력
        System.out.println("===== 아기사자 명단 =====");

        for (int i = 0; i < names.length; i++) {
            System.out.println((i + 1) + ". " + names[i]);
        }

        scanner.close();
    }
}