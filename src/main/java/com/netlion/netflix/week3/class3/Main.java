package com.netlion.netflix.week3.class3;

import com.netlion.netflix.week3.class3.role.Lion;
import com.netlion.netflix.week3.class3.role.Member;
import com.netlion.netflix.week3.class3.role.Staff;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== 아기사자 정보 입력 =====");
        System.out.println("이름:");
        String lionName = scanner.nextLine();
        System.out.println("전공:");
        String lionMajor = scanner.nextLine();
        System.out.println("기수:");
        int lionGeneration = Integer.parseInt(scanner.nextLine());
        System.out.println("파트 (백엔드/프론트엔드/기획/디자인):");
        String lionPart = scanner.nextLine();
        System.out.println("학번:");
        String studentId = scanner.nextLine();

        Member lion = new Lion(lionName, lionMajor, lionGeneration, lionPart, studentId);

        System.out.println();
        System.out.println("===== 운영진 정보 입력 =====");
        System.out.println("이름:");
        String staffName = scanner.nextLine();
        System.out.println("전공:");
        String staffMajor = scanner.nextLine();
        System.out.println("기수:");
        int staffGeneration = Integer.parseInt(scanner.nextLine());
        System.out.println("파트 (백엔드/프론트엔드/기획/디자인):");
        String staffPart = scanner.nextLine();
        System.out.println("직책 (대표/부대표/파트장/멘토):");
        String position = scanner.nextLine();

        Member staff = new Staff(staffName, staffMajor, staffGeneration, staffPart, position);

        System.out.println();
        System.out.println("===== 결과 출력 =====");
        lion.printInfo();
        staff.printInfo();
    }
}
