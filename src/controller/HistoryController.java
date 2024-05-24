/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.History;

public class HistoryController {
    private History history;

    public HistoryController(History history) {
        this.history = history;
    }

    public String getHistory() {
        StringBuilder sb = new StringBuilder();
        for (String operation : history.getOperations()) {
            sb.append(operation).append("\n");
        }
        return sb.toString();
    }
}

