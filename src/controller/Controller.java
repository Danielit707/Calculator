package controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import model.Model;
import model.History;
import model.Operation;
import view.View;

import java.util.List;

public class Controller implements ActionListener {
    
    Model model = new Model();
    View view = new View();
    
    public Controller (){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public Controller (View view, Model model) {
        
        this.view = view;
        this.model = model;
        
        this.view.getAddButton().addActionListener(this);
        this.view.getSubstractButton().addActionListener(this);
        this.view.getMultiplyButton().addActionListener(this);
        this.view.getDivideButton().addActionListener(this);
        this.view.getPotencyButton().addActionListener(this);
        
    }
    
    public void init () {
        
        view.setTitle("Calculator");
        view.setLocationRelativeTo(null);
        view.getNumber1Field().setText(String.valueOf(model.getNumber1()));
        view.getNumber2Field().setText(String.valueOf(model.getNumber2()));
        
    
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        model.setNumber1(Double.parseDouble(view.getNumber1Field().getText()));
        model.setNumber2(Double.parseDouble(view.getNumber2Field().getText()));
        
        if (e.getSource() == view.getAddButton()){
            model.setOperator("+");
        }
        if (e.getSource() == view.getSubstractButton()){
            model.setOperator("-");
        }
        if (e.getSource() == view.getMultiplyButton()){
            model.setOperator("*");
        }
        if (e.getSource() == view.getDivideButton()){
            model.setOperator("/");
        }
        if (e.getSource() == view.getPotencyButton()){
            model.setOperator("**");
        }
        
    }
    
 
}

