/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.*;

public class DivideController extends BaseOperation {
    private History history;

    public DivideController(History history) {
        this.history = history;
    }

    @Override
    public Response execute(double number1, double number2) {
        if (validateInput(number1, number2)) {
            if (number2 != 0) {
                double result = roundToThreeDecimals(number1 / number2);
                history.addOperation(number1 + " / " + number2 + " = " + result);
                return new Response("Success", 200, result);
            } else {
                return new Response("Division by zero", 400, 0);
            }
        } else {
            return new Response("Invalid input", 400, 0);
        }
    }
}

