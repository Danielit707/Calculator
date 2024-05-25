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

        this.addController = new AddController(historyController);
        this.subtractController = new SubtractController(historyController);
        this.multiplyController = new MultiplyController(historyController);
        this.divideController = new DivideController(historyController);
        this.potencyController = new PotencyController(historyController);

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
        historyController.getHistory(); // Inicializar el historial al inicio
    }

    @Override
public void actionPerformed(ActionEvent e) {
    if (!view.number1Field.getText().isEmpty() && !view.number2Field.getText().isEmpty()) {
        String number1 = view.number1Field.getText();
        String number2 = view.number2Field.getText();
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
    } else {
        // Manejar el caso en que los campos de texto están vacíos
        // Por ejemplo, mostrar un mensaje de error al usuario
    }

    if (e.getSource() == view.clearNumbersButton) {
        view.number1Field.setText("");
        view.number2Field.setText("");
        view.resultField.setText("");
    }
}

}


