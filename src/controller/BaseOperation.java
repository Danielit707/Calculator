package controller;

import model.*;

public abstract class BaseOperation {

    protected Operation operation;  
    protected String operator;
    protected Model model;
    private HistoryController historyC;

    public BaseOperation(HistoryController historyC, Model model) {
        this.historyC = historyC;
        this.model = model;
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
            model.setNumber1(toDouble(number1String));
            model.setNumber2(toDouble(number2String));
            model.setTotal(roundToThreeDecimals(operation.calculate(model.getNumber1(), model.getNumber2())));
            this.historyC.updateHistory(model.getNumber1(), model.getNumber2(), operator, model.getTotal());
            return new Response("Success", 200, model.getTotal());
        } else {
            return new Response("Invalid input", 400, 0);
        }
    }
}
