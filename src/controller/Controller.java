package controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import model.*;
import model.History;
import model.Operation.*;
import view.View;

import java.util.List;

public class Controller implements ActionListener {
    
    private Model model;
    private View view;
   
    
    public Controller (){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public Controller (View view, Model model) {
        
        this.view = view;
        this.model = model;
        
        
        this.view.addButton.addActionListener(this);
        this.view.substractButton.addActionListener(this);
        this.view.multiplyButton.addActionListener(this);
        this.view.divideButton.addActionListener(this);
        this.view.potencyButton.addActionListener(this);
        
    }
    
    public void init () {
        
        view.setTitle("Calculator");
        view.setLocationRelativeTo(null);
        
    
    }
    
    
    public void actionPerformed(ActionEvent e){
        
        double number1 = 0.0;
        double number2 = 0.0;
        
        try {
            number1 = Double.parseDouble(view.number1Field.getText());
        } catch (NumberFormatException ex) {
            // Manejar excepción si el usuario ingresó un valor no válido
            view.resultField.setText("Error: Invalid input for number 1");
            return; // Salir del método si hay un error
        }
        
        try {
            number2 = Double.parseDouble(view.number2Field.getText());
        } catch (NumberFormatException ex) {
            // Manejar excepción si el usuario ingresó un valor no válido
            view.resultField.setText("Error: Invalid input for number 2");
            return; // Salir del método si hay un error
        }
        
        model.setNumber1(number1);
        model.setNumber2(number2);
        
        Operation operation = null;
        
        if (e.getSource() == view.addButton){
            operation = new Add();
        }
        if (e.getSource() == view.substractButton){
            operation = new Substract();
        }
        if (e.getSource() == view.multiplyButton){
            model.setOperator("*");
            operation = new Multiply();
        }
        if (e.getSource() == view.divideButton){
            model.setOperator("/");
            operation = new Divide();
        }
        if (e.getSource() == view.potencyButton){
            model.setOperator("**");
            operation = new Potency();
        }
        
       
        double result = operation.calculate(model.getNumber1(), model.getNumber2());
        view.resultField.setText(String.valueOf(result));

        
    }
    
 
}


