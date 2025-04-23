package newCalculator;

import java.util.Scanner;

public class InputNumberAndOperator {
    Scanner sc = new Scanner(System.in);

    public static ManageInputOperator.Operator classifiedOperator;
    public double number1, number2;

    public void inputNumber() {

        System.out.print("첫 번째 실수를 입력하세요: ");
        this.number1 = sc.nextDouble();

        System.out.print("두 번째 실수를 입력하세요: ");
        this.number2 = sc.nextDouble();

        System.out.print("사칙 연산자를 입력하세요: ");

        while (true) {
            char inputOperator = sc.next().charAt(0);

            try {
                classifiedOperator = ManageInputOperator.Operator.fromSymbol(inputOperator);

                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
