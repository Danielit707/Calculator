package main;

import controller.Controller;
import model.Model;
import model.History;
import view.View;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        History history = new History();
        View view = new View();
        Controller controller = new Controller(view, model, history);
        controller.init();
        view.setVisible(true);
    }
}
