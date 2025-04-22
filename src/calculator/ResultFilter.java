package calculator;

import java.util.List;
import java.util.Scanner;

@FunctionalInterface

public interface ResultFilter { //

        void filter(List<Double> results); // ResultFilter 라는 함수형 인터페이스의 추상 메서드 선언부

        ResultFilter resultFilter = (results) -> { // filter(List<Double> results) 메서드의 구현체 역할을 하는 부분
        Scanner sc = new Scanner(System.in);
        System.out.print("기준값을 입력하세요: ");
        double filterNumber = sc.nextDouble();

        List<Double> filtered = results.stream() // 스트림 활용
                .filter(num -> num > filterNumber)
                .toList();

        if (filtered.isEmpty()) {
            System.out.println("입력한 값보다 큰 결과가 없습니다.");
        } else {
            System.out.print("결과값들 : ");
            filtered.forEach(num -> System.out.print(num + "  /  "));
            System.out.println();
        }
    };
}
