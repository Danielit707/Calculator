/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.operations;

import model.operations.Operation;

/**
 *
 * @author RYZEN
 */
public class Multiply implements Operation {
    
    @Override
    public double calculate (double number1, double number2) {
        
        return number1 * number2;
        
    }
    
}
