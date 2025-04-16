package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            boolean possible = true; // boolean은 연산 처리와 오류 방지 로직을 깔끔하게 제어하기 위한 장치로써 사용했다.
                                     // 다음 계산시에 true로 다시 바꿔주기 위해 반복문 맨 윗줄에 적어주었다.

            System.out.print("첫 번째 양의 정수를 입력하세요: ");
            int positiveInteger1 = sc.nextInt();

            System.out.print("두 번째 양의 정수를 입력하세요: ");
            int positiveInteger2 = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요 : ");
            char operator = sc.next().charAt(0);

            double result = 0; // 나눗셈에서 소숫점까지 표현해주기 위해 double로 표현

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
                        System.out.println(); // 줄을 한 칸 띄어주기 위해
                        continue; // 두 번째 양의 정수가 0이더라도 계산결과를 나타내주는 것을 방지하기 위해 현재 반복을 건너뛰게 해주었다.
                    } else {
                        result = (double) positiveInteger1 / positiveInteger2;
                    }
                    break;

                default:
                    System.out.println("올바른 사칙연산 기호를 입력해주세요.");
                    possible = false;
            }

            if (possible){
                System.out.println("결과: " + result);
            }

            System.out.print("엔터키를 누르면 다음 계산으로 넘어갑니다. (exit 입력 시 종료)");
            sc.nextLine(); // 엔터키를 통해 다음 계산으로 부드럽게 넘어갈 수 있다.
            String inputExit = sc.nextLine(); // 단어를 입력받을 준비
            if (inputExit.equals("exit")){
                System.out.println("계산기를 종료합니다.");
                break;
            }
            System.out.println(); // 다음 계산으로 넘어갈 때 한칸 띄어주기 위해
        }
        sc.close();
    }
}
