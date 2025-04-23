package newCalculator;

import java.util.ArrayList;
import java.util.List;

public class Calculation {
    InputData inputData;
    private final List<Double> results = new ArrayList<>();

    public Calculation(InputData inputData) {
        this.inputData = inputData;
    }

    public List<Double> getResults() {
        return results;
    }

    public void calculate() {
        try {
            double result = InputData.operator.apply(inputData.n1, inputData.n2);
            results.add(result);
            System.out.println("연산 결과 : " + result);
            System.out.println();
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }
    }
}
