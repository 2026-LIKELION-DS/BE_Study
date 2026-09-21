package class2.package1;

public class Lion {
    // 1. 서로 다른 접근 제어자 선언 (public, default, private)
    public String name;
    String major;          // default 접근 제어자
    private int generation;

    // 2. 세 필드를 모두 초기화하는 생성자 (안내 문구 출력 금지)
    public Lion(String name, String major, int generation) {
        this.name = name;
        this.major = major;
        this.generation = generation;
    }

    // 3. Step 2용: 객체가 자신의 상태를 스스로 검증하는 메서드
    public boolean isValid() {
        if (this.name == null || this.name.trim().isEmpty()) {
            System.out.println("❌ 이름이 비어 있습니다.");
            return false;
        }
        if (this.major == null || this.major.trim().isEmpty()) {
            System.out.println("❌ 전공이 비어 있습니다.");
            return false;
        }
        if (this.generation < 1) {
            System.out.println("❌ 기수는 1 이상이어야 합니다.");
            return false;
        }
        return true;
    }

    // 4. 정보 출력 메서드
    public void printInfo() {
        System.out.println("\uD83D\uDC35 아기사자 정보를 출력합니다.");
        System.out.println("\uD83D\uDC64 이름: " + this.name + " | \uD83C\uDF93 전공: " + this.major + " | \uD83D\uDCCC 기수: " + this.generation);
    }
}