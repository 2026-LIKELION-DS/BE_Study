# 1. 프로젝트 & 스프링 부트 구조 

스프링부트는 파일과 설정을 효율적으로 관리하기 위해 정해진 폴더 구조를 사용함 

---

## 1) src/main/java (자바 소스 코드 저장소)

프로그램의 실제 로직을 담당하는 자바 파일(.java)들을 모아두는 공간

* com.likelion.likelionstudy (패키지)
    * 컴퓨터의 폴더와 같은 개념
    * 전 세계 개발자들이 작성한 코드나 클래스 이름이 중복되는 것을 방지함
    * 도메인 주소를 거꾸로 쓰는 관례(com.회사명.프로젝트명)를 따라 고유한 경로를 생성함
* LikelionstudyApplication.java (메인 클래스)
    * 프로그램의 시작점(Entry Point)
    * 내부에 main 메서드가 존재
    * 스프링부트 애플리케이션을 구동하고 필요한 초기 설정을 읽어오는 실행 스위치 역할

---

## 2) src/main/resources (코드 X 자원 저장소)

자바 코드가 아닌 프로그램 실행에 필요한 설정 파일이나 부속 자원들을 관리하는 공간

* 소스 코드와 설정/자원 파일을 분리하여 관리 편의성을 높이기 위함
* application.properties(또는 application.yml) 같은 환경 설정 파일, HTML/CSS/JS 파일, 이미지 파일 등

---

## 3) build.gradle (프로젝트 빌드 및 의존성 관리 문서)

Gradle 빌드 도구가 프로젝트를 설정하고 실행하기 위해 참조하는 파일

* 프로젝트에서 사용하는 자바 버전 설정, 외부 라이브러리 다운로드 및 버전을 자동 관리하기 위해 사용
* 필요한 라이브러리 이름을 명시하면 인터넷 중앙 저장소에서 해당 파일들을 자동으로 다운로드하여 프로젝트에 연결함

---

## 4) .gitignore 

Git 버전 관리 시스템이 감지하지 않아야 할 파일이나 폴더를 지정하는 설정 파일입니다.

* 코드 실행 시 생성되는 임시 빌드 파일(build/), IDE 개인 설정 파일(.idea/), 보안이 필요한 비밀키 등을 깃허브에 올리지 않도록 차단
* 불필요한 파일 업로드를 방지하여 저장소 용량을 아끼고, 타 개발자와의 코드 충돌 예방

# 2. 구현 코드 및 자바 기본 개념 상세 분석

사용한 자바 문법: 입출력(Scanner), 조건문(while, if), 배열(Array), 반복문(for)

---

## 1) 패키지 및 라이브러리 임포트

```java
package com.likelion.likelionstudy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;
```

* `package` 이 클래스가 속한 폴더 위치 지정
* `import` 자바 기본 클래스(Scanner) 및 스프링부트 라이브러리 클래스들을 불러와 사용할 수 있도록 선언 

---
## 2) 메인 클래스 및 실행 구조

```java
@SpringBootApplication
public class LikelionstudyApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LikelionstudyApplication.class, args);
    }

    @Override
    public void run(String... args) {
        // 프로그램 실행 로직 위치
    }
}
```
* `@SpringBootApplicatoin` 해당 클래스가 스프링부트 애플리케이션의 시작점임을 알리는 어노테이션
* `implements CommandLineRunner` 스프링 부트 구동 시 웹 서버를 띄우는 대신, 콘솔 상에서 run 메서드 내부의 자바 코드를 즉시 실행하도록 해주는 역할

---
## 3) 입력 객체 생성 및 입력값 검증
```java
Scanner scanner = new Scanner(System.in);
int count = 0;

while (true) {
    System.out.println("🦁 저장할 아기사자 수를 5 이상 입력해주세요.");
    count = scanner.nextInt();

    if (count >= 5) {
        break;
    }

    System.out.println("❗ [오류] 5 이상 입력해주세요.");
}
```
* `Scanner scanner = new Scanner(System.in)` 키보드 입력(System.in)을 처리하기 위해 입력 객체를 생성
* `int count = 0` 아기사자의 인원수를 저장할 정수형(int) 기본 데이터 타입 변수를 선언
* `while (true)` 조건이 맞을 때까지 탈출하지 않고 반복 수행 
* `scanner.nextInt()` 콘솔에 입력된 값 중 정수 형태의 숫자를 읽어옴
* `if (count >= 5) { break; }` 입력값이 5 이상일 경우 break문을 만나 while 무한 루프를 탈출함. 5 미만일 경우에는 오류 메시지를 출력하고 루프의 처음으로 돌아가 재입력 요청함
---
## 4) 배열 생성 및 데이터 저장
```java
String[] names = new String[count];

System.out.println("✏️ 아기사자 이름을 입력해주세요.");
for (int i = 0; i < count; i++) {
    names[i] = scanner.next();
}
```
* `String[] names = new String[count]` 입력받은 숫자인 count 크기만큼 문자열(String)을 저장할 수 있는 참조 타입 배열을 동적으로 생성
  * 프로그램 실행 중 사용자에게 입력받은 숫자만큼 실시간으로 메모리 공간을 할당함 (알아서 자바 가비지 컬렉터가 회수함)
* `for (int i = 0; i < count; i++)` i 변수를 0부터 시작하여 count - 1까지 1씩 증가시키며 입력받은 숫자만큼 반복
* `scanner.next()` 사용자가 입력한 이름(문자열)을 읽어옴
---
## 5) 저장된 데이터 출력 
```java
System.out.println(); 

System.out.println("📋 아기사자 명단을 최종적으로 출력합니다.");
for (int i = 0; i < count; i++) {
    System.out.println("🦁 " + (i + 1) + ". " + names[i]);
}

scanner.close();
```
* (i + 1): 배열 인덱스는 0부터 시작하지만, 출력되는 번호표는 1번부터 시작하도록 1을 더해 출력함
* `scanner.close()` 입출력 스트림 자원을 해제하여 메모리 누수를 방지함 (키보드 입력 받아오기 위한 입출력 스트림!)