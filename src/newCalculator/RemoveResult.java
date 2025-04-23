package newCalculator;

public class RemoveResult {

    Calculation calculation;

    public RemoveResult(Calculation calculation) {
        this.calculation = calculation;
    }

    public void removeResult() {
        if (!calculation.getResults().isEmpty()) {
            System.out.println("삭제된 값: " + calculation.getResults().removeFirst());
            for (int i = 0; i < calculation.getResults().size(); i++) {
                System.out.println((i + 1) + "번째 결과 값 : " + calculation.getResults().get(i));
            }
        } else {
            System.out.println("연산 데이터가 존재하지 않습니다.");
        }
    }
}
