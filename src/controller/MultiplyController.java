package controller;

import model.*;

public class MultiplyController extends BaseOperation {
        
    public MultiplyController(HistoryController historyC, Model model) {
        super(historyC, model);
        this.operation = new Multiply();
        this.model.setOperator("*");
    }
    
}

