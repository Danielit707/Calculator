package controller;

import model.*;

public class MultiplyController extends BaseOperation {
    private String operator = "*";
        
    public MultiplyController(HistoryController historyC) {
        super(historyC);
        this.operation = new Multiply();
        this.operator = "*";
    }
}

