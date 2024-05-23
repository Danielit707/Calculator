package controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import model.Model;
import model.History;
import model.Operation;
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
        view.number1Field.setText(String.valueOf(model.getNumber1()));
        view.number2Field.setText(String.valueOf(model.getNumber2()));
        
    
    }
    
    
    public void actionPerformed(ActionEvent e){
        model.setNumber1(Double.parseDouble(view.number1Field.getText()));
        model.setNumber2(Double.parseDouble(view.number2Field.getText()));
        
        if (e.getSource() == view.addButton){
            model.setOperator("+");
        }
        if (e.getSource() == view.substractButton){
            model.setOperator("-");
        }
        if (e.getSource() == view.multiplyButton){
            model.setOperator("*");
        }
        if (e.getSource() == view.divideButton){
            model.setOperator("/");
        }
        if (e.getSource() == view.potencyButton){
            model.setOperator("**");
        }
        
        

        
    }
    
 
}

