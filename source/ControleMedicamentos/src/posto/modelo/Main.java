
package posto.modelo;

import posto.control.*;


public class Main {


    public static void main(String[] args) {
        Medicamento drugs = new Medicamento("Allahi akbar","Teste","17-10-1992", "0014",14);
        InsereMedicamento tst = new InsereMedicamento();
        tst.InsereMedicamentos(drugs);
    }
    
}
