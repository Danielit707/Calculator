/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.*;

public class MultiplyController extends BaseOperation {
    private HistoryController historyC;

    public MultiplyController(HistoryController historyC) {
        this.historyC = historyC;
    }

    @Override
    public Response execute(double number1, double number2) {
        if (validateInput(number1, number2)) {
            double result = roundToThreeDecimals(number1 * number2);
            this.historyC.updateHistory(number1, number2, "*", result);
            return new Response("Success", 200, result);
        } else {
            return new Response("Invalid input", 400, 0);
        }
    }
}

