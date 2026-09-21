package pbl2.domain;

public class Lion {
    // 요구사항: 세 필드에 각각 서로 다른 접근 제어자 사용
    public String name;       // public: 어디서든 접근 가능
    String major;             // default (package-private): 같은 패키지 내에서만 접근 가능
    private int generation;   // private: Lion 클래스 내부에서만 접근 가능

    // 생성자
    public Lion(String name, String major, int generation) {
        this.name = name;
        this.major = major;
        this.generation = generation;
    }

    // Step 2: 객체 내부에서 자산 상태를 직접 검증하는 메서드
    public boolean isValid() {
        if (this.name == null || this.name.trim().isEmpty()) {
            System.out.println("[오류] 이름이 비어 있습니다.");
            return false;
        }
        if (this.major == null || this.major.trim().isEmpty()) {
            System.out.println("[오류] 전공이 비어 있습니다.");
            return false;
        }
        if (this.generation < 1) {
            System.out.println("[오류] 기수는 1 이상이어야 합니다.");
            return false;
        }
        return true;
    }

    // 아기사자 정보 출력
    public void printInfo() {
        System.out.println("\n===== 아기사자 정보 =====");
        System.out.println("이름: " + this.name);
        System.out.println("전공: " + this.major);
        System.out.println("기수: " + this.generation + "기");
    }

    // private 필드인 generation을 읽기 위한 Getter (필요 시 사용)
    public int getGeneration() {
        return generation;
    }
}