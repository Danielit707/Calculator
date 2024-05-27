package controller.operations;

import controller.HistoryController;
import controller.operations.BaseOperation;
import model.*;

public class MultiplyController extends BaseOperation {
        
    public MultiplyController(HistoryController historyC, Model model) {
        super(historyC, model);
        this.operation = new Multiply();
        this.operator = "*";
    }
    
}

