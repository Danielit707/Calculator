package controller;

import model.*;

public class DivideController extends BaseOperation {
    private String operator = "/";
        
    public DivideController(HistoryController historyC) {
        super(historyC);
        this.operation = new Divide();
        this.operator = "/";
    }
    
}

