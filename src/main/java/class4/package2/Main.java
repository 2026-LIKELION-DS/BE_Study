package class4.package2;

import class4.role.Lion;
import class4.role.Member;
import class4.role.Staff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Member> members = new ArrayList<>();

        Map<String, List<Member>> partMembers = new HashMap<>();


        while (true) {

            System.out.println();
            System.out.println("===== 🦁 멤버 관리 시스템 =====");
            System.out.println("1. 멤버 등록");
            System.out.println("2. 전체 멤버 조회");
            System.out.println("3. 이름으로 검색");
            System.out.println("4. 파트별 조회");
            System.out.println("5. 종료");
            System.out.print("선택: ");

            int menu = scanner.nextInt();
            scanner.nextLine();


            switch (menu) {

                case 1:

                    System.out.println();
                    System.out.println("— 📝 멤버 등록 —");

                    System.out.print("역할 선택 (1: 아기사자, 2: 운영진): ");
                    int role = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("👤 이름: ");
                    String name = scanner.nextLine();


                    boolean duplicate = false;

                    for (Member member : members) {

                        if (member.getName().equals(name)) {
                            duplicate = true;
                            break;
                        }
                    }


                    if (duplicate) {
                        System.out.println(
                                "❌ 등록 실패: 이미 존재하는 이름입니다."
                        );
                        break;
                    }


                    System.out.print("🎓 전공: ");
                    String major = scanner.nextLine();

                    System.out.print("📌 기수: ");
                    int generation = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("💻 파트: ");
                    String part = scanner.nextLine();


                    Member newMember;


                    if (role == 1) {

                        System.out.print("🆔 학번: ");
                        String studentId = scanner.nextLine();

                        newMember = new Lion(
                                name,
                                major,
                                generation,
                                part,
                                studentId
                        );

                    } else if (role == 2) {

                        System.out.print("⭐ 직책: ");
                        String position = scanner.nextLine();

                        newMember = new Staff(
                                name,
                                major,
                                generation,
                                part,
                                position
                        );

                    } else {

                        System.out.println("❌ 잘못된 역할입니다.");
                        break;
                    }


                    // 전체 멤버 List에 추가
                    members.add(newMember);


                    // 파트별 Map에 추가
                    if (!partMembers.containsKey(part)) {
                        partMembers.put(part, new ArrayList<>());
                    }

                    partMembers.get(part).add(newMember);


                    System.out.println(
                            "✅ 등록 완료: "
                                    + newMember.getName()
                    );

                    break;


                case 2:

                    System.out.println();
                    System.out.println("— 📋 전체 멤버 목록 —");

                    if (members.isEmpty()) {
                        System.out.println("등록된 멤버가 없습니다.");
                        break;
                    }

                    int number = 1;

                    for (Member member : members) {

                        System.out.println(
                                number + ". "
                                        + "[" + member.getRoleName() + "] "
                                        + member.getName()
                                        + " - "
                                        + member.getGeneration()
                                        + "기"
                        );

                        number++;
                    }

                    System.out.println(
                            "📊 총 "
                                    + members.size()
                                    + "명"
                    );

                    break;


                case 3:

                    System.out.println();
                    System.out.println("— 🔍 이름으로 검색 —");

                    System.out.print("검색할 이름: ");
                    String searchName = scanner.nextLine();

                    Member foundMember = null;


                    for (Member member : members) {

                        if (member.getName().equals(searchName)) {
                            foundMember = member;
                            break;
                        }
                    }


                    if (foundMember != null) {

                        System.out.println();
                        System.out.println("✨ [검색 결과]");

                        System.out.println(
                                foundMember.getDetailInfo()
                        );

                        System.out.println(
                                "📝 과제 제출 가능 여부: "
                                        + foundMember.getSubmitResult()
                        );

                    } else {

                        System.out.println(
                                "❌ 해당 이름의 멤버를 찾을 수 없습니다."
                        );
                    }

                    break;


                case 4:

                    System.out.println();
                    System.out.println("— 💻 파트별 조회 —");


                    if (partMembers.isEmpty()) {
                        System.out.println("등록된 파트가 없습니다.");
                        break;
                    }


                    System.out.println(
                            "📂 등록된 파트: "
                                    + partMembers.keySet()
                    );


                    System.out.print("조회할 파트: ");
                    String searchPart = scanner.nextLine();


                    if (!partMembers.containsKey(searchPart)) {
                        System.out.println(
                                "❌ 존재하지 않는 파트입니다."
                        );
                        break;
                    }


                    List<Member> selectedMembers =
                            partMembers.get(searchPart);


                    System.out.println();
                    System.out.println(
                            "✨ [" + searchPart + " 파트 멤버]"
                    );


                    int partNumber = 1;

                    for (Member member : selectedMembers) {

                        System.out.println(
                                partNumber + ". "
                                        + member.getName()
                                        + " (" + member.getRoleName() + ")"
                                        + " - "
                                        + member.getGeneration()
                                        + "기"
                        );

                        partNumber++;
                    }

                    break;


                case 5:

                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;


                default:

                    System.out.println("❌ 잘못된 메뉴입니다.");
            }
        }
    }
}