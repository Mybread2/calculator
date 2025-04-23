package newCalculator;

public class Operators {

    public enum Operator {
        ADD('+'){
            public double apply(double n1, double n2){
                return n1 + n2;
            }
        },
        SUBTRACT('-'){
            public double apply(double n1, double n2){
                return n1 - n2;
            }
        },
        MULTIPLE('*'){
            public double apply(double n1, double n2){
                return n1 * n2;
            }
        },
        DIVIDE('/'){
            public double apply(double n1, double n2){
                if (n2 == 0){
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
                return n1 / n2 ;
            }
        };

        private final char symbol;

        Operator(char symbol){
            this.symbol = symbol;
        }

        public abstract double apply(double n1, double n2);

        public static Operator fromSymbol(char symbol){
            for (Operator op : Operator.values()){
                if (op.symbol == symbol){
                    return op;
                }
            }
            throw new IllegalArgumentException("올바른 사칙 연산자를 입력해주세요.");
        }

    }

}
