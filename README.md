# Java 사칙연산 계산기 프로젝트
 
 Java의 객체지향적 설계와 함수형 프로그래밍 요소(`Optional`, `@FunctionalInterface`, `enum`, `lambda`)를 활용한 사칙연산 계산기입니다.  
 
 ---
 
 ## 프로젝트 구조
 
 ```
 calculator/
 ├── App.java                  // 메인 클래스 - 사용자 입력 및 흐름 제어
 ├── OperationExecutor.java   // 실제 계산 수행 및 연산자 정의 (enum 사용)
 ├── ResultHistory.java       // 연산 결과 저장 및 삭제 기능
 └── ResultFilter.java        // 결과 필터링 인터페이스 (@FunctionalInterface + lambda)
 ```
 
 ---
 
 ## 주요 기능
 
 ### 1. 사칙연산 수행
 - `+`, `-`, `*`, `/` 연산 지원
 - 잘못된 연산자 입력 시 `IllegalArgumentException` 처리
 - 0으로 나누는 경우 `ArithmeticException` 예외 처리
 - 연산자 처리는 `enum`을 통해 명확하고 안전하게 구현
 - <https://juno0112.tistory.com/21>
 - <https://juno0112.tistory.com/23>
 ### 2. 결과 이력 관리
 - 연산 결과 자동 저장
 - 가장 먼저 저장된 결과 삭제 가능
 - 전체 이력 조회
 
 ### 3. 결과 필터링
 - 기준값을 입력 받아, 해당 값보다 큰 결과만 필터링하여 출력
 - `@FunctionalInterface` + `lambda`를 활용하여 필터 로직 구현
 - Java Stream API(`Stream.filter`) 활용
 - <https://juno0112.tistory.com/22>
 
 ---
 
 ## 실행 흐름
 
 1. 사용자로부터 두 수와 연산자를 입력 받는다.
 2. 유효한 연산자인 경우 계산 수행 및 결과 출력
 3. 결과는 `ResultHistory`에 저장된다.
 4. 이후 사용자에게 다음 옵션을 선택하도록 안내:
    - `계산`: 새로운 계산 수행
    - `삭제`: 가장 오래된 결과 삭제
    - `조회`: 전체 조회 또는 특정 기준 이상 결과 조회
    - `종료`: 계산기 종료
 
 ---
 
 ## 예외 처리
 
 ```java
 try {
     double result = executor.execute(num1, num2, operator);
 } catch (IllegalArgumentException | ArithmeticException e) {
     System.out.println(e.getMessage());
 }
 ```
 - **IllegalArgumentException**: 잘못된 연산자 기호 입력 시
 - **ArithmeticException**: 0으로 나눌 경우
 
 try-catch문을 활용해 2가지의 예외 타입 처리를 해주었다.
 
 ---
 
 ## 사용 기술
 
 - Java 17+
 - OOP (객체지향 프로그래밍)
 - Generics
 - Enum을 통한 연산자 관리
 - Lambda expressions
 - Optional
 - @FunctionalInterface
 - Java Stream API
 
 ---
 
 ## 느낀점
 
 강의를 듣고 직접 구현을 하는 과정이 처음에는 막막했다. 
 하지만 막힐 때마다 막히는 한 부분을 공부하려고 이것저것 찾아보면, 다른 개념에 대한 공부도 필요했다.
 그래서 하면 할 수록 더 많은 개념과 지식을 얻은 것 같다.
 아직 참고를 하지 않고 혼자서만 코드 구현을 하는 것은 어렵지만,
 구현 순서나 자바의 많은 기초 개념들을 이해할 수 있는 시간이 되어서 뜻깊었다. 

