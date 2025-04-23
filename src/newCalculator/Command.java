package newCalculator;

import java.util.Scanner;

public class Command {

    Scanner sc = new Scanner(System.in);
    CheckResults checkResults;
    Calculation calculation;
    RemoveResult removeResult;

    public Command(Calculation calculation, CheckResults checkResults, RemoveResult removeResult) {
        this.checkResults = checkResults;
        this.calculation = calculation;
        this.removeResult = removeResult;
    }


    public void command() {
        while (true) {
            System.out.println("추가적인 계산을 원하시면 '계산'을, 특정 값 이상의 데이터 조회를 원하시면 '조회'를, 가장 오래된 값 삭제를 원하시면 '삭제'를, 종료를 원하시면 '종료'를 입력해주세요.");
            String input = sc.nextLine();

            switch (input) {
                case "계산":
                    return;

                case "조회":
                    checkResults.filter(calculation.getResults());
                    break;

                case "종료":
                    System.out.println("계산기를 종료합니다.");
                    System.exit(0);

                case "삭제":
                    removeResult.removeResult();
                    break;

                default:
                    System.out.println("올바른 명령어를 입력해주세요.");
            }

        }
    }
}
