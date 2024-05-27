package controller.operations;

import controller.HistoryController;
import controller.operations.BaseOperation;
import model.operations.Subtract;
import model.*;

public class SubtractController extends BaseOperation {
        
    public SubtractController(HistoryController historyC, Model model) {
        super(historyC, model);
        this.operation = new Subtract();
        this.operator = "-";
    }
    
}
