/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.*;

public class AddController extends BaseOperation {
    private String operator = "+";
        
    public AddController(HistoryController historyC) {
        super(historyC);
        this.operation = new Add();
        this.operator = "+";
    }
}


