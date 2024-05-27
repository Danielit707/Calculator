/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.operations;
import model.operations.Operation;
import java.math.*;
/**
 *
 * @author RYZEN
 */
public class Potency implements Operation {
    
    @Override
    public double calculate (double number1, double number2) {
        
        return Math.pow(number1, number2);
        
    }
    
}
