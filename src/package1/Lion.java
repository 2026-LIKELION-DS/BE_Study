package package1;

public class Lion {
    public String name;       // 이름 - public
    String major;             // 전공 - default(package-private)
    private int generation;   // 기수 - private

    public Lion(String name, String major, int generation) {
        this.name = name;
        this.major = major;
        this.generation = generation;
    }

    // Step2: 객체 스스로 상태를 검증
    public boolean isValid() {
        if (name == null || name.isEmpty()) {
            System.out.println("❌ 이름이 비어 있습니다.");
            return false;
        }
        if (major == null || major.isEmpty()) {
            System.out.println("❌ 전공이 비어 있습니다.");
            return false;
        }
        if (generation < 1) {
            System.out.println("❌ 기수가 1 미만입니다.");
            return false;
        }
        return true;
    }

    public void printInfo() {
        System.out.println("🦁 아기사자 정보를 출력합니다.");
        System.out.println("👤 이름: " + name + " | 🚩 전공: " + major + " | 📌 기수: " + generation);
    }
}