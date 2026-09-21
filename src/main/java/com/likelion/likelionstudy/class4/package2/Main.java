package com.likelion.likelionstudy.class4.package2;

import com.likelion.likelionstudy.class4.role.Lion;
import com.likelion.likelionstudy.class4.role.Staff;
import com.likelion.likelionstudy.class4.role.User;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<User> members = new ArrayList<>();
        Map<String, List<User>> partMap = new HashMap<>();

        while (true) {
            System.out.println("========== 🦁 멤버 관리 시스템 ==========");
            System.out.println("1. 멤버 등록");
            System.out.println("2. 전체 멤버 조회");
            System.out.println("3. 이름으로 검색");
            System.out.println("4. 파트별 조회");
            System.out.println("5. 멤버 삭제");
            System.out.println("6. 기수 순 정렬 조회");
            System.out.println("7. 파트별 통계");
            System.out.println("8. 종료");
            System.out.print("선택: ");

            int menu = Integer.parseInt(scanner.nextLine());
            System.out.println();

            if (menu == 1) {
                System.out.println("― 📝 멤버 등록 ―");
                System.out.print("역할 선택 (1: 아기사자, 2: 운영진): ");
                int roleType = Integer.parseInt(scanner.nextLine());

                System.out.print("👤 이름: ");
                String name = scanner.nextLine();

                boolean exists = false;
                for (User m : members) {
                    if (m.getName().equals(name)) {
                        exists = true;
                        break;
                    }
                }

                if (exists) {
                    System.out.println("❌ 등록 실패: 이미 존재하는 이름입니다.\n");
                    continue;
                }

                System.out.print("🎓 전공: ");
                String major = scanner.nextLine();

                System.out.print("📌 기수: ");
                int gen = Integer.parseInt(scanner.nextLine());

                System.out.print("💻 파트 (백엔드/프론트엔드/기획/디자인): ");
                String part = scanner.nextLine();

                User newMember;
                if (roleType == 1) {
                    System.out.print("🆔 학번: ");
                    String studentId = scanner.nextLine();
                    newMember = new Lion(name, major, gen, part, studentId);
                } else {
                    System.out.print("⭐ 직책 (대표/부대표/파트장/멘토): ");
                    String position = scanner.nextLine();
                    newMember = new Staff(name, major, gen, part, position);
                }

                members.add(newMember);

                if (!partMap.containsKey(part)) {
                    partMap.put(part, new ArrayList<>());
                }
                partMap.get(part).add(newMember);

                System.out.println("✅ 등록 완료: " + name + "\n");

            } else if (menu == 2) {
                System.out.println("― 📋 전체 멤버 목록 ―");
                for (int i = 0; i < members.size(); i++) {
                    User m = members.get(i);
                    System.out.println((i + 1) + ". [" + m.getRoleName() + "] " + m.getName() + " - " + m.getGeneration() + "기");
                }
                System.out.println("📊 총 " + members.size() + "명\n");

            } else if (menu == 3) {
                System.out.println("― 🔍 이름으로 검색 ―");
                System.out.print("검색할 이름: ");
                String searchName = scanner.nextLine();
                System.out.println();

                boolean found = false;
                for (User m : members) {
                    if (m.getName().equals(searchName)) {
                        System.out.println("✨ [검색 결과]");
                        System.out.println("🎭 역할: " + m.getRoleName());
                        System.out.println("이름: " + m.getName() + " | 전공: " + m.getMajor() + " | 기수: " + m.getGeneration() + " | 파트: " + m.getPart());
                        System.out.println(m.getDetailInfo());
                        String submitStatus = m.canSubmitAssignment() ? "✅ 가능" : "❌ 불가능";
                        System.out.println("📝 과제 제출 가능 여부: " + submitStatus + "\n");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("해당 이름의 멤버를 찾을 수 없습니다.\n");
                }

            } else if (menu == 4) {
                System.out.println("― 💻 파트별 조회 ―");
                System.out.println("📁 등록된 파트: " + partMap.keySet());
                System.out.print("조회할 파트: ");
                String searchPart = scanner.nextLine();
                System.out.println();

                if (partMap.containsKey(searchPart) && !partMap.get(searchPart).isEmpty()) {
                    System.out.println("✨ [" + searchPart + " 파트 멤버]");
                    List<User> partMembers = partMap.get(searchPart);
                    for (int i = 0; i < partMembers.size(); i++) {
                        User m = partMembers.get(i);
                        System.out.println((i + 1) + ". " + m.getName() + " (" + m.getRoleName() + ") - " + m.getGeneration() + "기");
                    }
                    System.out.println();
                } else {
                    System.out.println("해당 파트에 등록된 멤버가 없습니다.\n");
                }

            } else if (menu == 5) {
                System.out.println("― 🗑️ 멤버 삭제 ―");
                System.out.print("삭제할 이름: ");
                String targetName = scanner.nextLine();

                User targetMember = null;
                for (User m : members) {
                    if (m.getName().equals(targetName)) {
                        targetMember = m;
                        break;
                    }
                }

                if (targetMember != null) {
                    members.remove(targetMember);
                    String part = targetMember.getPart();
                    if (partMap.containsKey(part)) {
                        partMap.get(part).remove(targetMember);
                    }
                    System.out.println("✅ 삭제 완료: " + targetName + "\n");
                } else {
                    System.out.println("❌ 삭제 실패: 존재하지 않는 이름입니다.\n");
                }

            } else if (menu == 6) {
                System.out.println("― 📊 기수 순 정렬 조회 ―");
                List<User> sortedMembers = new ArrayList<>(members);
                sortedMembers.sort(Comparator.comparingInt(User::getGeneration));

                for (int i = 0; i < sortedMembers.size(); i++) {
                    User m = sortedMembers.get(i);
                    System.out.println((i + 1) + ". [" + m.getGeneration() + "기] " + m.getName() + " (" + m.getRoleName() + ")");
                }
                System.out.println();

            } else if (menu == 7) {
                System.out.println("― 📈 파트별 통계 ―");
                String[] defaultParts = {"백엔드", "프론트엔드", "기획", "디자인"};
                for (String p : defaultParts) {
                    int count = partMap.containsKey(p) ? partMap.get(p).size() : 0;
                    System.out.println(p + ": " + count + "명");
                }
                System.out.println("--------------------");
                System.out.println("총 멤버: " + members.size() + "명\n");

            } else if (menu == 8) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
        scanner.close();
    }
}