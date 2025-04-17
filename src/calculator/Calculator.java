package calculator;


import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private List<Double> results = new ArrayList<>(); // 연산 결과들을 저장하는 컬렉션 타입 필드


    public void calculate(int positiveInteger1, int positiveInteger2, char operator) {
        // App에서 입력받은 데이터 3개를 가져오는 기능

        boolean possible = true; // boolean은 연산 처리와 오류 방지 로직을 깔끔하게 제어하기 위한 장치로써 사용했다.
                                 // 사칙연산 기능을 Calculator 클래스에 만들어주었고, 반복문은 App 클래스에 구현이 되어있어서
                                 // 이 클래스 내에는 continue를 사용하지 못한다. 따라서 조건문을 통해 오류 로직을 제어하기 위해 사용했다.

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
                    possible = false;
                    System.out.println(); // 줄을 한 칸 띄어주기 위해
                } else {
                    result = (double) positiveInteger1 / positiveInteger2;
                }
                break;

            default:
                possible = false;
        }

        if (possible) {
            System.out.println("결과: " + result);

            results.add(result); // results는 List<Double> 타입의 리스트이다.
                                 // result는 연산이 끝난 후에 얻은 데이터 값이다.
                                 // 그 result 값을 results 리스트에 추가하겠다는 의미
        }
    }


    public List<Double> getResults() { // getter 메서드
        return this.results;           // results는 연산 결과들을 저장하는 리스트이고 getResults()는 그 리스트를 읽어올 수 있게 해주는 메서드
    }

    public void setResults(List<Double> results) { // setter 메서드
        this.results = results;
    }

        public void removeResults() { // 기록된 값 맨 첫 번째 삭제하는 메서드
            List<Double> getterResults = getResults();

             if (!getterResults.isEmpty()) {
                 double removed = getterResults.remove(0); // 리스트에서 가장 오래된 연산결과 삭제
                 System.out.println("삭제된 값 : " + removed);
                 setResults(getterResults);  // 리스트 갱신

                 for (int i = 0; i < getterResults.size(); i++) {
                     System.out.println((i + 1) + "번째 결과값 : " + getterResults.get(i));
                 }
             } else {
                 System.out.println("삭제할 연산 결과가 존재하지 않습니다.");
             }
        }
    }



