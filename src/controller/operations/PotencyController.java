package controller.operations;

import controller.HistoryController;
import controller.operations.BaseOperation;
import model.operations.Potency;
import model.*;

public class PotencyController extends BaseOperation {
        
    public PotencyController(HistoryController historyC, Model model) {
        super(historyC, model);
        this.operation = new Potency();
        this.operator = "^";
    }
    
}

