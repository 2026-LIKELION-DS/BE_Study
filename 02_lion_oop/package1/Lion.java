package package1;

public class Lion {

    public String name;
    String major;
    private int generation;

    //세 필드를 모두 초기화하는 생성자
    public Lion(String name, String major, int generation) {
        this.name = name;
        this.major = major;
        this.generation = generation;
    }

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

    // 아기사자 정보 출력
    public void printInfo() {
        System.out.println("👤 이름: " + name + " | 🎓 전공: " + major + " | 📌 기수: " + generation);
    }
}
