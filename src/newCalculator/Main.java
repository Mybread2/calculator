package newCalculator;

public class Main {
    public static void main(String[] args) {

        InputData inputData = new InputData();
        Calculation calculation = new Calculation(inputData);
        CheckResults checkResults = new CheckResults();
        RemoveResult removeResult = new RemoveResult(calculation);
        Command command = new Command(calculation, checkResults, removeResult);

        while (true) {
            inputData.inputNumber();

            calculation.calculate();

            command.command();
        }
    }
}
