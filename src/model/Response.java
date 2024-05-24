/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Response {
    private String message;
    private int statusCode;
    private double result;

    public Response(String message, int statusCode, double result) {
        this.message = message;
        this.statusCode = statusCode;
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public double getResult() {
        return result;
    }
}
