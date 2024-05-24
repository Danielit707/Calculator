/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.Response;

public abstract class BaseOperation {
    protected boolean validateInput(double number1, double number2) {
        return hasThreeDecimals(number1) && hasThreeDecimals(number2);
    }

    protected boolean hasThreeDecimals(double number) {
        String[] parts = String.valueOf(number).split("\\.");
        return parts.length == 1 || parts[1].length() <= 3;
    }

    protected double roundToThreeDecimals(double number) {
        return Math.round(number * 1000.0) / 1000.0;
    }

    public abstract Response execute(double number1, double number2);
}

