package calculator;

import java.util.Objects;

public class OperationExecutor<T extends Number> {
    private final ResultHistory resultHistory; // ResultHistory 객체를 참조하는 resultHistory 필드

    public OperationExecutor(ResultHistory resultHistory) { // ResultHistory 객체를 인자로 받아 resultHistory 필드에 저장
        this.resultHistory = resultHistory;
    }

    public enum Operator {
        ADD('+') {
            public double apply(Number n1, Number n2) {
                return n1.doubleValue() + n2.doubleValue();
            }
        },
        SUBTRACT('-') {
            public double apply(Number n1, Number n2) {
                return n1.doubleValue() - n2.doubleValue();
            }
        },
        MULTIPLY('*') {
            public double apply(Number n1, Number n2) {
                return n1.doubleValue() * n2.doubleValue();
            }
        },
        DIVIDE('/') {
            public double apply(Number n1, Number n2) {
                if (n2.doubleValue() == 0.0) {
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
                return n1.doubleValue() / n2.doubleValue();
            }
        };

        private final char symbol; // 각 연산자에 대응되는 문자 기호를 저장

        Operator(char symbol) { // 각 enum 값 생성 시 기호를 설정하는 생성자
            this.symbol = symbol;
        }

        public abstract double apply(Number n1, Number n2); // 각 연산자마다 구현해야 하는 추상 메서드. 두 정수를 받아 계산한 결과를 반환

        public static Operator fromSymbol(char symbol) { // 연산자 기호를 받아서 해당하는 Operator enum 값을 반환. 일치하는 것이 없으면 예외 처리
            for (Operator op : Operator.values()) {
                if (op.symbol == symbol) {
                    return op;
                }
            }
            return null;
        }
    }

    public double execute(T num1, T num2, char operator) { // 두 실수와 연산자 기호를 입력받아 계산을 수행하고 결과를 반환하는 메서드
        double result = Objects.requireNonNull(Operator.fromSymbol(operator)).apply(num1, num2); // fromSymbol을 통해 operator(ADD,DIVIDE...)를 구하고, apply()를 호출해 Operator를 실행한 계산 결과를 얻는다.
        resultHistory.getResults().add(result); // 계산 결과를 ResultHistory에 저장
        return result;
    }
}



