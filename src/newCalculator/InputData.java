package newCalculator;

import java.util.Scanner;

public class InputData {
    Scanner sc = new Scanner(System.in);

    public static Operators.Operator operator;
    public double n1, n2;

    public void inputNumber() {

            System.out.println("첫 번째 실수를 입력하세요.");
            this.n1 = sc.nextDouble();

            System.out.println("두 번째 실수를 입력하세요.");
            this.n2 = sc.nextDouble();

            System.out.println("사칙 연산자를 입력하세요.");

            while (true) {
                char inputOperator = sc.next().charAt(0);

                try {
                operator = Operators.Operator.fromsymbol(inputOperator);
                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

    }
}
