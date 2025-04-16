package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Calculator calc = new Calculator(); // Calculator 인스턴스 생성

        List<Double> newResults = new ArrayList<>(); // getter 사용, App 클래스에서 연산 결과를 관리할 수 있는 기능

        Scanner sc = new Scanner(System.in);

        inputLoop : while (true) {
            System.out.print("첫 번째 양의 정수를 입력하세요: ");
            int positiveInteger1 = sc.nextInt();

            System.out.print("두 번째 양의 정수를 입력하세요: ");
            int positiveInteger2 = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요 : ");
            char operator = sc.next().charAt(0);
            sc.nextLine();

            calc.calculate(positiveInteger1, positiveInteger2, operator); // 생성한 인스턴스 활용

            secondLoop :while (true) {
                System.out.println("다음 계산을 하고싶다면 '계산'을 입력 / 삭제를 원하면 '삭제'를 입력 / 계산기를 종료하고싶다면 'exit' 입력");


                String inputExit = sc.nextLine(); // 단어를 입력받을 준비


                switch (inputExit) {
                    case "exit":
                        System.out.println("계산기를 종료합니다.");
                        break secondLoop;
                    case "삭제":
                        calc.removeResults();
                        break;
                    case "계산":
                        continue inputLoop;
                    default:
                        System.out.println("올바른 입력 값이 아닙니다.");
                        break;
                }
            }
            sc.close();
            break;
        }
    }
}