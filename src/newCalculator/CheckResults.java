package newCalculator;

import java.util.List;
import java.util.Scanner;

public class CheckResults {

    Scanner sc = new Scanner(System.in);

    public void filter(List<Double> results){
        System.out.println("기준 값을 입력하세요: ");
        double filterNumber = sc.nextDouble();

        List<Double> filtered = results.stream()
                .filter(num -> num > filterNumber)
                .toList();

        if(filtered.isEmpty()){
            System.out.println("입력한 값보다 큰 연산 결과가 없습니다.");
        } else {
            System.out.println("결과 값들 : ");
            filtered.forEach(num -> System.out.print(num + "  /  "));
            System.out.println();
        }
    }

}