package newCalculator;

public class Main {
    public static void main(String[] args) {
        while (true) {
            InputData inputData = new InputData();
            inputData.inputNumber();

            Calculation calculation = new Calculation(inputData);
            calculation.calculate();

            Command command = new Command(calculation, new CheckResults(), new RemoveResult(calculation));
            command.command();
        }
    }
}
