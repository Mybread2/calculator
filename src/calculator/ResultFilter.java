package calculator;

import java.util.List;
import java.util.Scanner;

@FunctionalInterface

public interface ResultFilter {

    void filter(List<Double> results);

    static void resultFilter (List<Double> results) {
        Scanner sc = new Scanner(System.in);
        System.out.print("기준값을 입력하세요: ");
        double filterNumber = sc.nextDouble();

        List<Double> filtered = results.stream()
                .filter(num -> num > filterNumber)
                .toList();

        if (filtered.isEmpty()) {
            System.out.println("입력한 값보다 큰 결과가 없습니다.");
        } else {
            System.out.print("결과값들 : ");
            filtered.forEach(num -> System.out.print(num + "  /  "));
            System.out.println();
        }
    }
}