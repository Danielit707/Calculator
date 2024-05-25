/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.Response;

public abstract class BaseOperation {
    protected boolean validateInput(String number1String, String number2String) {
        boolean isNumeric;
        boolean hasThreeDecimals = false;

        try {
            double number1 = toDouble(number1String);
            double number2 = toDouble(number2String);
            isNumeric = true;
            
            if(hasThreeDecimals(number1) && hasThreeDecimals(number2)){
                hasThreeDecimals = true;
            }
        
        } catch (NumberFormatException exception){
            isNumeric = false;
            
        }
        
        return isNumeric && hasThreeDecimals;
        
    }

    protected boolean hasThreeDecimals(double number) {
        String[] parts = String.valueOf(number).split("\\.");
        return parts.length == 1 || parts[1].length() <= 3;
    }

    protected double roundToThreeDecimals(double number) {
        return Math.round(number * 1000.0) / 1000.0;
    }
    
    protected double toDouble (String numberString){
        
       double numberDouble = Double.parseDouble(numberString);
       
       return numberDouble;

    }

    public abstract Response execute(String number1String, String number2String);
}

