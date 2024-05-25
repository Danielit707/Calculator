/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.*;

public class AddController extends BaseOperation {
    private HistoryController historyC;

    public AddController(HistoryController historyC) {
        this.historyC = historyC;
    }

    @Override
    public Response execute(String number1String, String number2String) {
        if (validateInput(number1String, number2String)) {
            double number1 = toDouble(number1String);
            double number2 = toDouble(number2String);
            double result = roundToThreeDecimals(number1 + number2);
            this.historyC.updateHistory(number1, number2, "+", result);
            return new Response("Success", 200, result);
        } else {
            return new Response("Invalid input", 400, 0);
        }
    }
}
