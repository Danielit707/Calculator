/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.DefaultListModel;
import model.History;
import view.View;

public class HistoryController {
    
    private History history;
    private View view;
    private DefaultListModel<String> model;

    public HistoryController(History history, View view) {
        this.history = history;
        this.view = view;
        this.model = new DefaultListModel<>();
        this.view.historyList.setModel(model);
    }

    public void getHistory() {
        model.removeAllElements();
        for (String operation : history.getOperations()) {
            model.addElement(operation);
        }
    }

    public void updateHistory(double number1, double number2, String operation, double result) {
        String num1 = String.valueOf(number1);
        String num2 = String.valueOf(number2);
        String res = String.valueOf(result);
        String operationString = num1 + " " + operation + " " + num2 + " = " + res;
        history.addOperation(operationString);
    }
}


