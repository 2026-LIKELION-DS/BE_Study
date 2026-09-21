import java.util.Scanner;

public class BabyLionRoster {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = 0;
        while (true) {
            System.out.print("아기사자 수를 입력하세요 (5 이상): ");
            count = scanner.nextInt();

            if (count < 5) {
                System.out.println("5 미만은 입력할 수 없습니다. 다시 입력해주세요.");
            } else {
                break;
            }
        }

        String[] names = new String[count];

        scanner.nextLine();
        for (int i = 0; i < count; i++) {
            System.out.print((i + 1) + "번째 아기사자 이름을 입력하세요: ");
            names[i] = scanner.nextLine();
        }

        System.out.println("\n===== 아기사자 명단 =====");
        for (int i = 0; i < names.length; i++) {
            System.out.println((i + 1) + ". " + names[i]);
        }

        scanner.close();
    }
}