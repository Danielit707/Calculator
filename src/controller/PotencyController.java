package controller;

import model.*;

public class PotencyController extends BaseOperation {
    private String operator = "^";
        
    public PotencyController(HistoryController historyC) {
        super(historyC);
        this.operation = new Potency();
        this.operator = "^";
    }
}

