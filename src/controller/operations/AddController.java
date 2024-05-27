/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.operations;

import controller.HistoryController;
import model.operations.Add;
import model.*;

public class AddController extends BaseOperation {
             
    public AddController(HistoryController historyC, Model model) {
        
        super(historyC, model);
        this.operator = "+";
        this.operation = new Add();
        
    }
    
}


