package class5.package2;

import class5.role.Lion;
import class5.role.Member;
import class5.role.Staff;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.println("🔧 저장소를 선택하세요:");
        System.out.println(
                "1. MemoryMemberRepository (실제 저장)"
        );
        System.out.println(
                "2. MockMemberRepository (더미 데이터)"
        );
        System.out.print("선택: ");

        int repositoryChoice = scanner.nextInt();
        scanner.nextLine();


        MemberRepository repository;


        if (repositoryChoice == 1) {

            repository = new MemoryMemberRepository();

        } else if (repositoryChoice == 2) {

            repository = new MockMemberRepository();

        } else {

            System.out.println("❌ 잘못된 선택입니다.");
            scanner.close();
            return;
        }


        // 의존성 주입
        MemberService service = new MemberService(repository);


        while (true) {

            System.out.println();
            System.out.println(
                    "🦁 ===== 멋사 멤버 관리 시스템 (Step 2: DI 적용) ===== 🦁"
            );

            System.out.println("1. ➕ 멤버 등록");
            System.out.println("2. 📋 전체 멤버 조회");
            System.out.println("3. 🔍 이름으로 검색");
            System.out.println("4. 🚪 종료");
            System.out.print("선택: ");


            int menu = scanner.nextInt();
            scanner.nextLine();


            switch (menu) {

                case 1:
                    registerMember(scanner, service);
                    break;

                case 2:
                    showAllMembers(service);
                    break;

                case 3:
                    searchMember(scanner, service);
                    break;

                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;

                default:
                    System.out.println("❌ 잘못된 메뉴입니다.");
            }
        }
    }


    private static void registerMember(
            Scanner scanner,
            MemberService service
    ) {

        System.out.println();

        System.out.print(
                "👤 역할 선택 (1: 아기사자, 2: 운영진): "
        );

        int role = scanner.nextInt();
        scanner.nextLine();


        System.out.println();
        System.out.println("📝 정보 입력");

        System.out.print("이름: ");
        String name = scanner.nextLine();

        System.out.print("전공: ");
        String major = scanner.nextLine();

        System.out.print("기수: ");
        int generation = scanner.nextInt();
        scanner.nextLine();

        System.out.print("파트: ");
        String part = scanner.nextLine();


        Member member;


        if (role == 1) {

            System.out.print("학번: ");
            String studentId = scanner.nextLine();

            member = new Lion(
                    name,
                    major,
                    generation,
                    part,
                    studentId
            );

        } else if (role == 2) {

            System.out.print("직책: ");
            String position = scanner.nextLine();

            member = new Staff(
                    name,
                    major,
                    generation,
                    part,
                    position
            );

        } else {

            System.out.println("❌ 잘못된 역할입니다.");
            return;
        }


        boolean result = service.register(member);


        if (result) {

            System.out.println();
            System.out.println(
                    "✅ 등록 완료: "
                            + member.getName()
            );

        } else {

            System.out.println();
            System.out.println(
                    "❌ 등록 실패: 이미 존재하는 이름입니다."
            );
        }
    }


    private static void showAllMembers(MemberService service) {

        List<Member> members = service.getAllMembers();

        System.out.println();
        System.out.println("📋 ===== 전체 멤버 목록 =====");


        if (members.isEmpty()) {

            System.out.println("등록된 멤버가 없습니다.");
            return;
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
                "📊 총 " + members.size() + "명"
        );
    }


    private static void searchMember(
            Scanner scanner,
            MemberService service
    ) {

        System.out.println();

        System.out.print("🔍 검색할 이름: ");
        String name = scanner.nextLine();


        Member member =
                service.findMemberByName(name);


        if (member == null) {

            System.out.println(
                    "❌ 해당 이름의 멤버를 찾을 수 없습니다."
            );

            return;
        }


        System.out.println();
        System.out.println(
                "🎯 ===== 검색 결과 ====="
        );

        System.out.println(
                member.getDetailInfo()
        );

        System.out.println(
                "📝 과제 제출 가능: "
                        + member.getSubmitResult()
        );
    }
}