package class4.package2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import class4.role.Lion;
import class4.role.Role;
import class4.role.Staff;

/**
 * (Step 2) Step 1(List)에 Map<String, List<Role>>을 추가해,
 * 파트명을 키로 멤버 목록을 그룹화하는 기능까지 지원하는 메뉴 기반 프로그램.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Role> members = new ArrayList<>();
        Map<String, List<Role>> partMap = new LinkedHashMap<>();

        while (true) {
            System.out.println("===== 🦁 멤버 관리 시스템 =====");
            System.out.println("1. 멤버 등록");
            System.out.println("2. 전체 멤버 조회");
            System.out.println("3. 이름으로 검색");
            System.out.println("4. 파트별 조회");
            System.out.println("5. 종료");
            System.out.print("선택: ");
            int choice = Integer.parseInt(sc.nextLine().trim());

            if (choice == 1) {
                System.out.println();
                System.out.println("— 📝 멤버 등록 —");
                System.out.print("역할 선택 (1: 아기사자, 2: 운영진): ");
                int roleChoice = Integer.parseInt(sc.nextLine().trim());

                System.out.print("👤 이름: ");
                String name = sc.nextLine();

                boolean duplicate = false;
                for (Role existing : members) {
                    if (existing.getName().equals(name)) {
                        duplicate = true;
                        break;
                    }
                }

                if (duplicate) {
                    System.out.println("❌ 등록 실패: 이미 존재하는 이름입니다.");
                } else {
                    System.out.print("🎓 전공: ");
                    String major = sc.nextLine();
                    System.out.print("📌 기수: ");
                    int generation = Integer.parseInt(sc.nextLine().trim());
                    System.out.print("💻 파트 (백엔드/프론트엔드/기획/디자인): ");
                    String part = sc.nextLine();

                    Role role;
                    if (roleChoice == 1) {
                        System.out.print("🆔 학번: ");
                        String studentId = sc.nextLine();
                        role = new Lion(name, major, generation, part, studentId);
                    } else {
                        System.out.print("⭐ 직책 (대표/부대표/파트장/멘토): ");
                        String position = sc.nextLine();
                        role = new Staff(name, major, generation, part, position);
                    }

                    members.add(role);

                    // Map에도 함께 등록한다: 해당 파트 키가 없으면 새 List를 만들어 넣는다.
                    if (!partMap.containsKey(part)) {
                        partMap.put(part, new ArrayList<>());
                    }
                    partMap.get(part).add(role);

                    System.out.println("✅ 등록 완료: " + name);
                }
                System.out.println();

            } else if (choice == 2) {
                System.out.println();
                System.out.println("— 📋 전체 멤버 목록 —");
                int index = 1;
                for (Role member : members) {
                    System.out.println(index + ". [" + member.getRoleName() + "] "
                            + member.getName() + " - " + member.getGeneration() + "기");
                    index++;
                }
                System.out.println("📊 총 " + members.size() + "명");
                System.out.println();

            } else if (choice == 3) {
                System.out.println();
                System.out.println("— 🔍 이름으로 검색 —");
                System.out.print("검색할 이름: ");
                String searchName = sc.nextLine();
                System.out.println();

                Role found = null;
                for (Role member : members) {
                    if (member.getName().equals(searchName)) {
                        found = member;
                        break;
                    }
                }

                if (found == null) {
                    System.out.println("❌ 해당 이름의 멤버를 찾을 수 없습니다.");
                } else {
                    System.out.println("✨ [검색 결과]");
                    System.out.println(found.getDetailInfo());
                    System.out.println("📝 과제 제출 가능 여부: " + (found.canSubmit() ? "✅ 가능" : "❌ 불가능"));
                }
                System.out.println();

            } else if (choice == 4) {
                System.out.println();
                System.out.println("— 💻 파트별 조회 —");
                System.out.println("📂 등록된 파트: " + partMap.keySet());
                System.out.print("조회할 파트: ");
                String searchPart = sc.nextLine();
                System.out.println();

                if (!partMap.containsKey(searchPart)) {
                    System.out.println("❌ 등록된 멤버가 없는 파트입니다.");
                } else {
                    System.out.println("✨ [" + searchPart + " 파트 멤버]");
                    List<Role> partMembers = partMap.get(searchPart);
                    int index = 1;
                    for (Role member : partMembers) {
                        System.out.println(index + ". " + member.getName()
                                + " (" + member.getRoleName() + ") - " + member.getGeneration() + "기");
                        index++;
                    }
                }
                System.out.println();

            } else if (choice == 5) {
                break;
            }
        }

        sc.close();
    }
}
