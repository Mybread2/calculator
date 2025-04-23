package newCalculator;

public class ManageInputOperator {

    public enum Operator {
        ADD('+') {
            public double apply(double number1, double number2) {
                return number1 + number2;
            }
        },
        SUBTRACT('-') {
            public double apply(double number1, double number2) {
                return number1 - number2;
            }
        },
        MULTIPLE('*') {
            public double apply(double number1, double number2) {
                return number1 * number2;
            }
        },
        DIVIDE('/') {
            public double apply(double number1, double number2) {
                if (number2 == 0) {
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
                return number1 / number2;
            }
        };

        private final char symbol;

        Operator(char symbol) {
            this.symbol = symbol;
        }

        public abstract double apply(double number1, double number2);

        public static Operator fromSymbol(char symbol) {
            for (Operator inputoperator : Operator.values()) {
                if (inputoperator.symbol == symbol) {
                    return inputoperator;
                }
            }
            throw new IllegalArgumentException("올바른 사칙 연산자를 입력해주세요.");
        }

    }

}
