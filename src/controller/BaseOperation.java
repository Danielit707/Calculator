package controller;

import model.*;

public abstract class BaseOperation {

    protected Operation operation;  
    protected String operator;
    private HistoryController historyC;

    public BaseOperation(HistoryController historyC) {
        this.historyC = historyC;
    }

    protected boolean validateInput(String number1String, String number2String, String operator) {
        boolean divideByZero = false;
        boolean isNumeric;
        boolean hasThreeDecimals = false;

        try {
            double number1 = toDouble(number1String);
            double number2 = toDouble(number2String);
            isNumeric = true;
            
            if (operator.equals("/") && number2 == 0){
                
                divideByZero = true;
            
            }
            
        
            
            if (hasThreeDecimals(number1) && hasThreeDecimals(number2)) {
                hasThreeDecimals = true;
            }
        
        } catch (NumberFormatException exception) {
            isNumeric = false;
        }
        
        return isNumeric && hasThreeDecimals && !divideByZero;
    }

    protected boolean hasThreeDecimals(double number) {
        String[] parts = String.valueOf(number).split("\\.");
        return parts.length == 1 || parts[1].length() <= 3;
    }

    protected double roundToThreeDecimals(double number) {
        return Math.round(number * 1000.0) / 1000.0;
    }

    protected double toDouble(String numberString) {
        return Double.parseDouble(numberString);
    }

    public Response execute(String number1String, String number2String, String operator) {
        if (validateInput(number1String, number2String, operator)) {
            double number1 = toDouble(number1String);
            double number2 = toDouble(number2String);
            double result = roundToThreeDecimals(operation.calculate(number1, number2));
            this.historyC.updateHistory(number1, number2, operator, result);
            return new Response("Success", 200, result);
        } else {
            return new Response("Invalid input", 400, 0);
        }
    }
}
