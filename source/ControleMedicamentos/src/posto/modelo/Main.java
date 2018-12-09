package posto.modelo;

import posto.control.*;

public class Main {

    public static void main(String[] args) {

        try {
            Menu menu = new Menu();
            menu.Apresentacao();
           
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
