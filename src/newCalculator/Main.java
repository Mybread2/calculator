package newCalculator;

public class Main {
    public static void main(String[] args) {

        InputNumberAndOperator NumbersAndOperator = new InputNumberAndOperator();
        CalculateOperations calculation = new CalculateOperations(NumbersAndOperator);
        CheckResults check = new CheckResults();
        RemoveFirstResult remove = new RemoveFirstResult(calculation);
        CommandVariousFunctions command = new CommandVariousFunctions(calculation, check, remove);

        while (true) {
            NumbersAndOperator.inputNumber();

            calculation.calculate();

            command.command();
        }
    }
}
