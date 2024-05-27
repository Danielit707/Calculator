package controller.operations;

import controller.HistoryController;
import controller.operations.BaseOperation;
import model.operations.Divide;
import model.*;

public class DivideController extends BaseOperation {
        
    public DivideController(HistoryController historyC, Model model) {
        super(historyC, model);
        this.operation = new Divide();
        this.operator = "/";
    }
    
}

