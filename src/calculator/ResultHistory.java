package calculator;

import java.util.ArrayList;
import java.util.List;

public class ResultHistory {

    private List<Double> results = new ArrayList<>();

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