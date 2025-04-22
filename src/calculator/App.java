package calculator;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ResultHistory resultHistory = new ResultHistory(); // Calculator 인스턴스 생성
        OperationExecutor<Double> executor = new OperationExecutor<>(resultHistory); // 제네릭을 사용하여 객체 생성

        inputLoop:
        while (true) {
            System.out.print("첫 번째 실수를 입력하세요 : ");
            double inputNumber1 = sc.nextDouble();

            System.out.print("두 번째 실수를 입력하세요 : ");
            double inputNumber2 = sc.nextDouble();

            char operator;

            while (true) {
                System.out.print("사칙연산 기호를 입력하세요 : ");
                operator = sc.next().charAt(0);
                sc.nextLine(); // 버퍼 비우기

                // 유효한 연산자인지 확인
                OperationExecutor.Operator op = OperationExecutor.Operator.fromSymbol(operator);
                if (op == null) {
                    System.out.println("지원하지 않는 연산자입니다. 다시 입력해주세요.");
                    continue;
                }

                double result = executor.execute(inputNumber1, inputNumber2, operator);
                System.out.println("계산 결과 : " + result);
                break;
            }

            List<Double> newResults = resultHistory.getResults(); // 계산 후 업데이트된 결과 리스트 가져오기
            resultHistory.setResults(newResults); // 업데이트된 리스트 설정

            secondLoop:
            while (true) {
                System.out.println("다음 계산을 하고싶다면 '계산'을 입력 / 삭제를 원하면 '삭제'를 입력 / 데이터 조회를 원한다면 '조회'를 입력 / 계산기를 종료하고싶다면 '종료'를 입력해주세요");

                String inputExit = sc.nextLine(); // 단어를 입력받을 준비

                switch (inputExit) {
                    case "종료":
                        System.out.println("계산기를 종료합니다.");
                        break secondLoop;
                    case "삭제":
                        resultHistory.removeResults();
                        newResults = resultHistory.getResults(); // 삭제 후 업데이트된 결과 리스트 가져오기
                        resultHistory.setResults(newResults); // 업데이트된 리스트 설정
                        break;
                    case "계산":
                        continue inputLoop;
                    case "조회":
                        System.out.println("1. 전체 결과 조회");
                        System.out.println("2. 특정 값보다 큰 결과 조회");
                        System.out.print("1 또는 2를 입력해주세요.");
                        String choice = sc.nextLine();

                        switch (choice) {
                            case "1":
                                for (int i = 0; i < resultHistory.getResults().size(); i++) {
                                    System.out.println((i + 1) + "번째 결과: " + resultHistory.getResults().get(i));
                                }
                                break;
                            case "2":
                                ResultFilter.resultFilter.filter(resultHistory.getResults()); // 저장된 결과값들을 filter 메서드에 전달하여 실행
                                break;
                            default:
                                System.out.println("올바른 입력 값이 아닙니다.");
                                break;
                        }
                }

            }
            sc.close();
            break;
        }
    }
}