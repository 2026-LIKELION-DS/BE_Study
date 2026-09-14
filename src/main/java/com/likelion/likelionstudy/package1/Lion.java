package com.likelion.likelionstudy.package1;

public class Lion {
    public String name;
    String major;
    private int generation;

    // 기본 생성자 (보너스 과제 1: 유효성 검증 포함)
    public Lion(String name, String major, int generation) {
        if (name == null || name.trim().isEmpty() ||
                major == null || major.trim().isEmpty() ||
                generation < 1) {
            // 보너스 과제 1
            return;
        }
        this.name = name;
        this.major = major;
        this.generation = generation;
    }

    public boolean validateSelf() {
        if (this.name == null || this.name.trim().isEmpty() ||
                this.major == null || this.major.trim().isEmpty() ||
                this.generation < 1) {
            System.out.println("❌ 이름이 비어 있습니다.");
            System.out.println("❌ 잘못된 아기사자 정보입니다.");
            return false;
        }
        System.out.println("✅ 아기사자 객체가 자신의 상태를 정상으로 판단했습니다.");
        return true;
    }

    // 아기사자 정보 출력 메서드
    public void printInfo() {
        System.out.println("🦁 아기사자 정보를 출력합니다.");
        System.out.println("👤 이름: " + this.name + " | 🎓 전공: " + this.major + " | 📌 기수: " + this.generation);
    }

    // 보너스 과제 3
    public boolean updateName(String newName) {
        if (newName == null || newName.trim().isEmpty()) {
            System.out.println("❌ 유효하지 않은 이름입니다. 변경에 실패했습니다.");
            return false;
        }
        this.name = newName;
        System.out.println("✅ 이름이 정상적으로 변경되었습니다.");
        return true;
    }

    public boolean updateMajor(String newMajor) {
        if (newMajor == null || newMajor.trim().isEmpty()) {
            System.out.println("❌ 유효하지 않은 전공입니다. 변경에 실패했습니다.");
            return false;
        }
        this.major = newMajor;
        System.out.println("✅ 전공이 정상적으로 변경되었습니다.");
        return true;
    }

    public boolean updateGeneration(int newGeneration) {
        if (newGeneration < 1) {
            System.out.println("❌ 기수는 1 이상이어야 합니다. 변경에 실패했습니다.");
            return false;
        }
        this.generation = newGeneration;
        System.out.println("✅ 기수가 정상적으로 변경되었습니다.");
        return true;
    }
}