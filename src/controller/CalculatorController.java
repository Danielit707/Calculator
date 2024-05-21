package controller;

import model.Calculator;
import model.History;
import model.Operation;
import view.CalculatorFrame;

import java.util.List;

public class CalculatorController {
    private final Calculator calculator;
    private final History history;
    private final CalculatorFrame view;

    public CalculatorController(Calculator calculator, History history, CalculatorFrame view) {
        this.calculator = calculator;
        this.history = history;
        this.view = view;
    }

    public void performOperation(String operation) {
        try {
            double number1 = view.getNumber1();
            double number2 = view.getNumber2();
            double result = 0;
            
            switch (operation) {
                case "add":
                    result = calculator.add(number1, number2);
                    history.addOperation(new Operation(number1, number2, "+", result));
                    break;
                case "subtract":
                    result = calculator.subtract(number1, number2);
                    history.addOperation(new Operation(number1, number2, "-", result));
                    break;
                case "multiply":
                    result = calculator.multiply(number1, number2);
                    history.addOperation(new Operation(number1, number2, "*", result));
                    break;
                case "divide":
                    result = calculator.divide(number1, number2);
                    history.addOperation(new Operation(number1, number2, "/", result));
                    break;
                default:
                    view.showError("Invalid Operation");
                    return;
            }
            
            view.setResult(result);
        } catch (NumberFormatException ex) {
            view.showError("Invalid number format");
        }
    }

    public void updateHistory() {
        List<Operation> operations = history.getOperations();
        view.updateHistory(operations);
    }
}

