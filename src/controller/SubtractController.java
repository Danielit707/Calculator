package controller;

import model.*;

public class SubtractController extends BaseOperation {
        
    public SubtractController(HistoryController historyC, Model model) {
        super(historyC, model);
        this.operation = new Subtract();
        this.operator = "-";
    }
    
}
