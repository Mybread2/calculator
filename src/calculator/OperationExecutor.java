package calculator;

public class OperationExecutor {
    private final ResultHistory resultHistory;

    public OperationExecutor(ResultHistory resultHistory) {
        this.resultHistory = resultHistory;
    }

    public enum Operator {
        ADD('+') {
            public double apply(int positiveInteger1, int positiveInteger2) {
                return positiveInteger1 + positiveInteger2;
            }
        },
        SUBTRACT('-') {
            public double apply(int positiveInteger1, int positiveInteger2) {
                return positiveInteger1 - positiveInteger2;
            }
        },
        MULTIPLY('*') {
            public double apply(int positiveInteger1, int positiveInteger2) {
                return positiveInteger1 * positiveInteger2;
            }
        },
        DIVIDE('/') {
            public double apply(int positiveInteger1, int positiveInteger2) {
                if (positiveInteger2 == 0) {
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
                return (double) positiveInteger1 / positiveInteger2;
            }
        };

        private final char symbol;

        Operator(char symbol) {
            this.symbol = symbol;
        }

        public abstract double apply(int positiveInteger1, int positiveInteger2);

        public static Operator fromSymbol(char symbol) {
            for (Operator op : Operator.values()) {
                if (op.symbol == symbol) {
                    return op;
                }
            }
            throw new IllegalArgumentException("지원하지 않는 연산자 입니다.");
        }
    }

    public double execute(int positiveInteger1, int positiveInteger2, char operator) {
        double result = Operator.fromSymbol(operator).apply(positiveInteger1, positiveInteger2);
        resultHistory.getResults().add(result);
        return result;

    }
}


