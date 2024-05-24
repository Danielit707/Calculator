package controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import model.*;
import view.View;

public class Controller implements ActionListener {
    
    private View view;
    private History history;
    private BaseOperation addController;
    private BaseOperation subtractController;
    private BaseOperation multiplyController;
    private BaseOperation divideController;
    private BaseOperation potencyController;
    private HistoryController historyController;

    public Controller(View view, Model model, History history) {
        this.view = view;
        this.history = history;

        this.addController = new AddController(history);
        this.subtractController = new SubtractController(history);
        this.multiplyController = new MultiplyController(history);
        this.divideController = new DivideController(history);
        this.potencyController = new PotencyController(history);
        this.historyController = new HistoryController(history);

        this.view.addButton.addActionListener(this);
        this.view.substractButton.addActionListener(this);
        this.view.multiplyButton.addActionListener(this);
        this.view.divideButton.addActionListener(this);
        this.view.potencyButton.addActionListener(this);
        this.view.updateHistoryButton.addActionListener(this);
    }

    public void init() {
        view.setTitle("Calculator");
        view.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double number1 = Double.parseDouble(view.number1Field.getText());
        double number2 = Double.parseDouble(view.number2Field.getText());
        Response response = null;

        if (e.getSource() == view.addButton) {
            response = addController.execute(number1, number2);
        } else if (e.getSource() == view.substractButton) {
            response = subtractController.execute(number1, number2);
        } else if (e.getSource() == view.multiplyButton) {
            response = multiplyController.execute(number1, number2);
        } else if (e.getSource() == view.divideButton) {
            response = divideController.execute(number1, number2);
        } else if (e.getSource() == view.potencyButton) {
            response = potencyController.execute(number1, number2);
        } else if (e.getSource() == view.updateHistoryButton) {
            view.historyList.addElement(historyController.getHistory());
            return;
        }

        if (response != null) {
            if(response.getStatusCode() == 400){            
                view.resultField.setText(response.getMessage());
            } else {
            view.resultField.setText(String.valueOf(response.getResult()));
            }
        }
    }
}



