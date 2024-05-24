/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author edangulo
 */
public class History {
    
    private ArrayList<String> operations;

    public History() {
        this.operations = new ArrayList<>();
    }
    
    public void addOperation(String operation) {
        this.operations.add(operation);
    }

    public ArrayList<String> getOperations() {
        return operations;
    }
    
}
