package calculator;

import controller.CalculatorController;
import model.Calculator;
import model.History;
import view.CalculatorFrame;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        History history = new History();
        CalculatorFrame view = new CalculatorFrame();
        CalculatorController controller = new CalculatorController(calculator, history, view);

        view.setVisible(true);
    }
}
