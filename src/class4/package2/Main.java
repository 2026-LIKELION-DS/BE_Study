package class4.package2;

import class4.role.Lion;
import class4.role.Role;
import class4.role.Staff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static List<Role> roleList = new ArrayList<>();
    private static Map<String, List<Role>> partMap = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== 🦁 멤버 관리 시스템 =====");
            System.out.println("1. 멤버 등록");
            System.out.println("2. 전체 멤버 조회");
            System.out.println("3. 이름으로 검색");
            System.out.println("4. 파트별 조회");
            System.out.println("5. 종료");
            System.out.print("선택: ");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    registerMember();
                    break;
                case "2":
                    printAllMembers();
                    break;
                case "3":
                    searchByName();
                    break;
                case "4":
                    searchByPart();
                    break;
                case "5":
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    return;
                default:
                    System.out.println("❌ 잘못된 입력입니다. 다시 선택해주세요.");
            }
        }
    }

    private static void registerMember() {
        System.out.println("\n— 📝 멤버 등록 —");
        System.out.print("역할 선택 (1: 아기사자, 2: 운영진): ");
        String roleChoice = sc.nextLine().trim();

        System.out.print("👤 이름: ");
        String name = sc.nextLine();

        if (isDuplicateName(name)) {
            System.out.println("❌ 등록 실패: 이미 존재하는 이름입니다.");
            return;
        }

        System.out.print("🚩 전공: ");
        String major = sc.nextLine();

        System.out.print("📌 기수: ");
        int generation;
        try {
            generation = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("❌ 기수는 숫자만 입력할 수 있습니다.");
            return;
        }

        System.out.print("💻 파트 (백엔드/프론트엔드/기획/디자인): ");
        String part = sc.nextLine();

        Role role;
        if (roleChoice.equals("1")) {
            System.out.print("🆔 학번: ");
            String studentId = sc.nextLine();
            role = new Lion(name, major, generation, part, studentId);
        } else if (roleChoice.equals("2")) {
            System.out.print("⭐ 직책 (대표/부대표/파트장/멘토): ");
            String position = sc.nextLine();
            role = new Staff(name, major, generation, part, position);
        } else {
            System.out.println("❌ 잘못된 역할 선택입니다.");
            return;
        }

        // List에 추가
        roleList.add(role);

        // Map에 추가 (해당 파트가 없으면 새 List 생성)
        partMap.computeIfAbsent(part, k -> new ArrayList<>()).add(role);

        System.out.println("✅ 등록 완료: " + name);
    }

    private static boolean isDuplicateName(String name) {
        for (Role r : roleList) {
            if (r.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    private static void printAllMembers() {
        System.out.println("\n— 📋 전체 멤버 목록 —");
        if (roleList.isEmpty()) {
            System.out.println("등록된 멤버가 없습니다.");
            return;
        }
        for (int i = 0; i < roleList.size(); i++) {
            Role r = roleList.get(i);
            System.out.println((i + 1) + ". [" + r.getRoleName() + "] " + r.getName() + " - " + r.getGeneration() + "기");
        }
        System.out.println("📊 총 " + roleList.size() + "명");
    }

    private static void searchByName() {
        System.out.println("\n— 🔍 이름으로 검색 —");
        System.out.print("검색할 이름: ");
        String name = sc.nextLine();

        for (Role r : roleList) {
            if (r.getName().equals(name)) {
                System.out.println("\n✨ [검색 결과]");
                System.out.println("🎭 역할: " + r.getRoleName());
                System.out.println(r.getCommonInfo());
                System.out.println(r.getDetailInfo());
                String result = r.canSubmitAssignment() ? "✅ 가능" : "❌ 불가능";
                System.out.println("📝 과제 제출 가능 여부: " + result);
                return;
            }
        }
        System.out.println("❌ 해당 이름의 멤버를 찾을 수 없습니다.");
    }

    private static void searchByPart() {
        System.out.println("\n— 💻 파트별 조회 —");
        if (partMap.isEmpty()) {
            System.out.println("등록된 파트가 없습니다.");
            return;
        }
        System.out.println("📂 등록된 파트: " + partMap.keySet());
        System.out.print("조회할 파트: ");
        String part = sc.nextLine();

        List<Role> roles = partMap.get(part);
        if (roles == null || roles.isEmpty()) {
            System.out.println("❌ 해당 파트에 등록된 멤버가 없습니다.");
            return;
        }

        System.out.println("\n🦁 [" + part + " 파트 멤버]");
        for (Role r : roles) {
            System.out.println("- [" + r.getRoleName() + "] " + r.getName() + " (" + r.getGeneration() + "기)");
        }
    }
}