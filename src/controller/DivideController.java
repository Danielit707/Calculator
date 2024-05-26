package controller;

import model.*;

public class DivideController extends BaseOperation {
        
    public DivideController(HistoryController historyC, Model model) {
        super(historyC, model);
        this.operation = new Divide();
        this.operator = "/";
    }
    
}

