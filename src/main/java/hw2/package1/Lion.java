package hw2.package1;

public class Lion {

    public String name;
    String major;
    private int generation;

    public Lion(String name, String major, int generation) {
        this.name = name;
        this.major = major;
        this.generation = generation;
    }

    // Step2에서 객체가 자신의 상태를 검증
    public boolean isValid() {

        if (name.trim().isEmpty()) {
            System.out.println("❌ 이름이 비어 있습니다.");
            return false;
        }

        if (major.trim().isEmpty()) {
            System.out.println("❌ 전공이 비어 있습니다.");
            return false;
        }

        if (generation < 1) {
            System.out.println("❌ 기수는 1 이상이어야 합니다.");
            return false;
        }

        return true;
    }

    public void printInfo() {
        System.out.println("👤 이름: " + name + " | 🎓 전공: " + major + " | 📌 기수: " + generation);
    }
}