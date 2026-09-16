import java.util.Scanner;

public class BabyLionManager {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;

        while (true) {
            System.out.println("🦁 저장할 아기사자 수를 5 이상 입력해주세요.");
            count = scanner.nextInt();
            scanner.nextLine();

            if (count >= 5) {
                break;
            } else {
                System.out.println("❗[오류] 5 이상 입력해주세요.");
            }
        }

        String[] lionNames = new String[count];

        System.out.println("✏️ 아기사자 이름을 입력해주세요.");
        for (int i = 0; i < count; i++) {
            lionNames[i] = scanner.nextLine();
        }

        System.out.println();
        
        System.out.println("아기사자 명단을 최종적으로 출력합니다.");
        for (int i = 0; i < count; i++) {
            System.out.println("🦁 " + (i + 1) + ". " + lionNames[i]);
        }

        scanner.close();
    }
}