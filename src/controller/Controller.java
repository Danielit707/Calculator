package controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import model.*;
import view.View;

public class Controller implements ActionListener {
    
    private View view;
    private Model model;
    private HistoryController historyController;
    private BaseOperation addController;
    private BaseOperation subtractController;
    private BaseOperation multiplyController;
    private BaseOperation divideController;
    private BaseOperation potencyController;

    public Controller(View view, Model model, History history) {
        this.view = view;
        this.model = model;
        this.historyController = new HistoryController(history, view);

        this.addController = new AddController(historyController, model);
        this.subtractController = new SubtractController(historyController, model);
        this.multiplyController = new MultiplyController(historyController, model);
        this.divideController = new DivideController(historyController, model);
        this.potencyController = new PotencyController(historyController, model);

        this.view.addButton.addActionListener(this);
        this.view.substractButton.addActionListener(this);
        this.view.multiplyButton.addActionListener(this);
        this.view.divideButton.addActionListener(this);
        this.view.potencyButton.addActionListener(this);
        this.view.updateHistoryButton.addActionListener(this);
        this.view.clearNumbersButton.addActionListener(this);
    }

    public void init() {
        view.setTitle("Calculator");
        view.setLocationRelativeTo(null);
        historyController.getHistory(); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Response response = null;
        if (!view.number1Field.getText().isEmpty() && !view.number2Field.getText().isEmpty()) {
            String number1 = view.number1Field.getText();
            String number2 = view.number2Field.getText();
        

            if (e.getSource() == view.addButton) {
                response = addController.execute(number1, number2, "+");
            } else if (e.getSource() == view.substractButton) {
                response = subtractController.execute(number1, number2, "-");
            } else if (e.getSource() == view.multiplyButton) {
                response = multiplyController.execute(number1, number2, "*");
            } else if (e.getSource() == view.divideButton) {
                response = divideController.execute(number1, number2, "/");
            } else if (e.getSource() == view.potencyButton) {
                response = potencyController.execute(number1, number2, "^");
            }
        }
        if (e.getSource() == view.updateHistoryButton) {
            historyController.getHistory();
            return;
        }

        if (response != null) {
            if (response.getStatusCode() == 400) {            
                view.resultField.setText(response.getMessage());
            } else {
                view.resultField.setText(String.valueOf(response.getResult()));
            }
        }
    

        if (e.getSource() == view.clearNumbersButton) {
            view.number1Field.setText("");
            view.number2Field.setText("");
            view.resultField.setText("");
        }
    }
}


