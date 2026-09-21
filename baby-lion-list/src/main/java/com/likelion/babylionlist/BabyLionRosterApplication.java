package com.likelion.babylionlist;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BabyLionRosterApplication implements CommandLineRunner {

	private static final int MIN_COUNT = 5;

	public static void main(String[] args) {
		SpringApplication.run(BabyLionRosterApplication.class, args);
	}

	@Override
	public void run(String... args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int count = readBabyLionCount(scanner);
			String[] names = readBabyLionNames(scanner, count);
			printRoster(names);
		}
	}

	private int readBabyLionCount(Scanner scanner) {
		while (true) {
			System.out.println("저장할 아기사자 수를 " + MIN_COUNT + " 이상 입력해주세요.");
			int count = Integer.parseInt(scanner.nextLine().trim());
			if (count >= MIN_COUNT) {
				return count;
			}
			System.out.println("[오류] " + MIN_COUNT + " 이상 입력해주세요.");
		}
	}

	private String[] readBabyLionNames(Scanner scanner, int count) {
		System.out.println("아기사자 이름을 입력해주세요.");
		String[] names = new String[count];
		for (int i = 0; i < count; i++) {
			names[i] = scanner.nextLine().trim();
		}
		return names;
	}

	private void printRoster(String[] names) {
		System.out.println("\n 아기사자 명단을 최종적으로 출력합니다.");
		for (int i = 0; i < names.length; i++) {
			System.out.println("🦁 " + (i + 1) + ". " + names[i]);
		}
	}
}
