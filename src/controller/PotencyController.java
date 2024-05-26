package controller;

import model.*;

public class PotencyController extends BaseOperation {
        
    public PotencyController(HistoryController historyC, Model model) {
        super(historyC, model);
        this.operation = new Potency();
        this.operator = "^";
    }
    
}

