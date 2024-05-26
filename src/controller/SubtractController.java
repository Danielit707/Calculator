package controller;

import model.*;

public class SubtractController extends BaseOperation {
    private String operator = "-";
        
    public SubtractController(HistoryController historyC) {
        super(historyC);
        this.operation = new Subtract();
        this.operator = "-";
    }
}
