package calculator;


import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private List<Double> results = new ArrayList<>();

    public void calculate(int positiveInteger1, int positiveInteger2, char operator) {
        boolean possible = true;
        double result = 0;

        switch (operator) {
            case '+':
                result = positiveInteger1 + positiveInteger2;
                break;

            case '-':
                result = positiveInteger1 - positiveInteger2;
                break;

            case '*':
                result = positiveInteger1 * positiveInteger2;
                break;

            case '/':
                if (positiveInteger2 == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    possible = false;
                    System.out.println();
                } else {
                    result = (double) positiveInteger1 / positiveInteger2;
                }
                break;

            default:
                possible = false;
        }

        if (possible) {
            System.out.println("결과: " + result);
            results.add(result);
            System.out.println();

            for (int i = 0; i < results.size(); i++) {
                System.out.println((i + 1) + "번째 결과값 : " + results.get(i));
            }
        }
    }

    public List<Double> getResults() { // getter 메서드
        return this.results;
    }

    public void setResults(List<Double> results) { // setter 메서드
        this.results = results;
    }

    public void removeResults() {
        if (!results.isEmpty()) {
            double removed = results.removeFirst();
            System.out.println("삭제된 값 : " + removed);
            System.out.println();

            if (!results.isEmpty()) {
                for (int i = 0; i < results.size(); i++) {
                    System.out.println((i + 1) + "번째 결과값 : " + results.get(i));
                }
            }
        } else {
            System.out.println("삭제할 연산 결과가 존재하지 않습니다.");
        }
        System.out.println();
    }
}